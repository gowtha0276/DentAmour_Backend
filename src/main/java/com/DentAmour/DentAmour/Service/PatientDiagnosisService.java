package com.DentAmour.DentAmour.Service;

import com.DentAmour.DentAmour.Helper.DateHelper;
import com.DentAmour.DentAmour.Helper.Utility;
import com.DentAmour.DentAmour.Interface.IPatientDiagnosisService;
import com.DentAmour.DentAmour.Models.PatientDiagnosis;
import com.DentAmour.DentAmour.Repository.PatientDiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDiagnosisService implements IPatientDiagnosisService {
    @Autowired
    PatientDiagnosisRepository patientDiagnosisRepository;
    @Autowired
    Utility utility;

    @Autowired
    DateHelper dateHelper;

    public int generateRandomNumber() {
        int uniqueId = utility.getRandom();
        PatientDiagnosis d = patientDiagnosisRepository.findById(Integer.toString(uniqueId)).orElse(null);
        if(d!=null)
            return generateRandomNumber();
        return uniqueId;
    }

    @Override
    public PatientDiagnosis createPatientDiagnosis(PatientDiagnosis patientDiagnosis)
    {
        patientDiagnosis.setDate(dateHelper.nowInIST());
        return patientDiagnosisRepository.save(patientDiagnosis);
    }


}
