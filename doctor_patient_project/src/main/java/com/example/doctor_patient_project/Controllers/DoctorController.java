package com.example.doctor_patient_project.Controllers;

import com.example.doctor_patient_project.Modules.Doctor;
import com.example.doctor_patient_project.Services.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

   public DoctorController(DoctorService doctorService)
   {
       this.doctorService=doctorService;
   }

    @PostMapping("/add-doctor")
    public String addDoctor(@RequestBody Doctor doctor)
    {
       return doctorService.addDoctor(doctor);
    }
    @DeleteMapping("/delete-doctor")
    public String deleteDoctor(@RequestParam ("Id") int dId)
    {
        return doctorService.deleteDoctor(dId);
    }
}
