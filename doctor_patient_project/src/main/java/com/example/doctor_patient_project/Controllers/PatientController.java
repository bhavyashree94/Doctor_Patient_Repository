package com.example.doctor_patient_project.Controllers;

import com.example.doctor_patient_project.Modules.Doctor;
import com.example.doctor_patient_project.Modules.Patient;
import com.example.doctor_patient_project.Services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/patient")
public class PatientController {
    private final PatientService patientService;
     public PatientController(PatientService patientService)
     {
         this.patientService = patientService;
     }
 @PostMapping("/add-patient")
    public String addPatient(@RequestBody Patient patient)
 {
      return patientService.addpatient(patient);
 }
 @DeleteMapping("/delete-patient")
    public String deletePatient(@RequestParam ("id") int patientId)throws Exception
 {
     return  patientService.deletePatient(patientId);
 }
    @GetMapping("/get-doctor-suggestion")
   public ResponseEntity getDoctorsBasedOnPatients(@RequestParam("id") int patientId) throws Exception
   {
       List<Doctor> doctorList;
       try {
           doctorList= patientService.getDoctorsBasedOnPatients(patientId);
       }
       catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
       }
       return new ResponseEntity<>(doctorList,HttpStatus.CREATED);
   }
}
