package com.example.doctor_patient_project.Services;

import com.example.doctor_patient_project.Modules.Doctor;
import com.example.doctor_patient_project.Modules.Patient;
import com.example.doctor_patient_project.Repositories.DoctorRepository;
import com.example.doctor_patient_project.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public String addpatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient added successfully";
    }


    public String deletePatient(int patientId) throws IllegalArgumentException{
        try {
            Patient patient = patientRepository.findById(patientId).get();
            patientRepository.delete(patient);
            return "Patient removed successfully";
        }
        catch (Exception e)
        {
           throw new IllegalArgumentException("patient is not found");
        }
    }
    public List<Doctor> getDoctorsBasedOnPatients(int patientId) throws IllegalArgumentException {
        Patient patient = new Patient();
        try {
            patient = patientRepository.findById(patientId).get();
        } catch (Exception e) {
            throw new IllegalArgumentException("Patient with id " + patientId + "Not Found");
        }
        List<Doctor> doctorsInCity = new ArrayList<>();
        {
            List<Doctor> doctors = doctorRepository.findAll();
            for (Doctor doctor : doctors) {
                if (doctor.getCity().equals(patient.getCity())) {
                    doctorsInCity.add(doctor);
                }

            }

            if (doctorsInCity.isEmpty()) {
                throw new IllegalArgumentException("We are still waiting to expand to your location");
            }

        }
        List<Doctor> suggestedDoctors = new ArrayList<>();
        for (Doctor doctor : doctorsInCity) {
            if (doctor.getDoctorSpeciality().equals(patient.getSymptom().getSpeciality())) {
                suggestedDoctors.add(doctor);
            }
        }
        if(suggestedDoctors.isEmpty()) {
            throw new IllegalArgumentException("There is no doctor is present at your location");
        }

        return suggestedDoctors;
    }
}
