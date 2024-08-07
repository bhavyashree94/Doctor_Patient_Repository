package com.example.doctor_patient_project.Services;

import com.example.doctor_patient_project.Modules.Doctor;
import com.example.doctor_patient_project.Repositories.DoctorRepository;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository)
    {
        this.doctorRepository=doctorRepository;
    }
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor added successfully";
    }

    public String deleteDoctor(int dId) {
       Doctor doctor = doctorRepository.findById(dId).get();
       doctorRepository.delete(doctor);
       return "Doctor removed successfully";
    }

}
