package com.DentAmour.DentAmour.Service;

import com.DentAmour.DentAmour.Helper.Utility;
import com.DentAmour.DentAmour.Interface.IPatientService;
import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    Utility utility;

    public int generateRandomNumber() {
        int uniqueId = utility.getRandom();
        Patient patient = patientRepository.findById(Integer.toString(uniqueId)).orElse(null);
        if(patient!=null)
            return generateRandomNumber();
        return uniqueId;
    }

    @Override
    public Patient createPatient(Patient patient)
    {
        patient.setAge(utility.calculateAge(patient.getDateOfBirth()));
        patient.setRegistrationID(Integer.toString(generateRandomNumber()));
        return patientRepository.save(patient);
    }

    @Override
    public void updatePatientById(String id,Patient patient) {

        Patient pat= patientRepository.findById(id).orElse(null);
        if (pat != null) {
            pat.setAllValues(patient);
            pat.setAge(utility.calculateAge(pat.getDateOfBirth()));
            patientRepository.save(pat);
        }
    }

    @Override
    public Patient findPatientByEmailId(String mail) {
        return patientRepository.findBymail(mail);
    }

    @Override
    public Patient findPatientByRegistrationId(String registrationId) {
        return patientRepository.findByregistrationID(registrationId);
    }

    @Override
    public List<Patient> findAllPatients() {
            return patientRepository.findAll();
    }

    @Override
    public void deletePatientByRegistrationId(String registrationId) {
        patientRepository.deleteByregistrationID(registrationId);
    }

    @Override
    public Patient findPatientByPhoneOrRegistrationId(String param)
    {
        Patient p=patientRepository.findByphone(param);
        if(p==null)
            p=patientRepository.findByregistrationID(param);
        return p;
    }
}
