package com.example.doctor_patient_project.Repositories;

import com.example.doctor_patient_project.Modules.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
