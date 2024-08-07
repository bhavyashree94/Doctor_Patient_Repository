package com.example.doctor_patient_project.Modules;

import com.example.doctor_patient_project.Enum.City;
import com.example.doctor_patient_project.Enum.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Size(min=3)
    private String patientName;

    @Enumerated(EnumType.STRING)
    City city;

    @Column(unique = true)
    private String patientEmail;

    @Size(min=10)
    private String patientMobile;
    @Enumerated(EnumType.STRING)
    Symptom symptom;

    private  String message;
}
