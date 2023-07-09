package com.DentAmour.DentAmour.Interface;

import com.DentAmour.DentAmour.Models.Patient;

import java.util.List;

public interface IPatientService {

    Patient findPatientByEmailId(String patientId);

    Patient findPatientByRegistrationId(String registrationId);

    List<Patient> findAllPatients();

    void deletePatientByRegistrationId(String registrationId);

    void updatePatientById(String id,Patient patient);

    Patient createPatient(Patient patient);

    Patient findPatientByPhoneOrRegistrationId(String param);
}
