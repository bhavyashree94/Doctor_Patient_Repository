package com.example.doctor_patient_project.Repositories;

import com.example.doctor_patient_project.Modules.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
