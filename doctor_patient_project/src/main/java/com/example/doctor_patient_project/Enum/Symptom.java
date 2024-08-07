package com.example.doctor_patient_project.Enum;

public enum Symptom {
    ARTHRITIS(DoctorSpeciality.ORTHOPEDIC),
    BACKPAIN(DoctorSpeciality.ORTHOPEDIC),
    TISSUE_INJURIES(DoctorSpeciality.ORTHOPEDIC),
    DYSMENORRHEA(DoctorSpeciality.GYNECOLOGY),
    SKIN_INFECTION(DoctorSpeciality.DERMATOLOGY),
    SKIN_BURN(DoctorSpeciality.DERMATOLOGY),
    EAR_PAIN(DoctorSpeciality.ENT),
    EYE_PAIN(DoctorSpeciality.ENT);

    private final DoctorSpeciality speciality;

    Symptom(DoctorSpeciality speciality) {
        this.speciality = speciality;
    }

    public DoctorSpeciality getSpeciality() {
        return this.speciality;
    }
}
