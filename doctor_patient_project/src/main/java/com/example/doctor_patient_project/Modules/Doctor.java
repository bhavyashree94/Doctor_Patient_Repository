package com.example.doctor_patient_project.Modules;

import com.example.doctor_patient_project.Enum.City;
import com.example.doctor_patient_project.Enum.DoctorSpeciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;

    @Size(min=3)
    private String doctorName;

    private String email;

    @Size(min=10)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    City city;
    @Enumerated(EnumType.STRING)
    DoctorSpeciality doctorSpeciality;

}
