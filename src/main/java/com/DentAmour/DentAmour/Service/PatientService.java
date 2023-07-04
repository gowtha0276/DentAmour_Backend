package com.DentAmour.DentAmour.Service;

import com.DentAmour.DentAmour.Helper.Utility;
import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

@Service
public class PatientService {
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
    public List<Patient> getPatient()
    {
        return patientRepository.findAll();
    }
    public Patient createPatient(Patient patient)
    {
        patient.setAge(utility.calculateAge(patient.getDateOfBirth()));
        patient.setRegistrationID(Integer.toString(generateRandomNumber()));
        return patientRepository.save(patient);
    }

    public void updatePatient(String id,Patient patient) {

        Patient pat= patientRepository.findById(id).orElse(null);
        if (pat != null) {
            pat.setAllValues(patient);
            pat.setAge(utility.calculateAge(pat.getDateOfBirth()));
            patientRepository.save(pat);
        }
    }

    public void deletePatient(String id)
    {
        patientRepository.deleteById(id);
    }

}
