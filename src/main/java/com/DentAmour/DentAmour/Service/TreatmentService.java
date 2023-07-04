package com.DentAmour.DentAmour.Service;

import com.DentAmour.DentAmour.Helper.Utility;
import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Models.Treatment;
import com.DentAmour.DentAmour.Repository.PatientRepository;
import com.DentAmour.DentAmour.Repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;
    @Autowired
    Utility utility;
    public int generateRandomNumber() {
        int uniqueId = utility.getRandom();
        Treatment treatment = treatmentRepository.findById(Integer.toString(uniqueId)).orElse(null);
        if(treatment!=null)
            return generateRandomNumber();
        return uniqueId;
    }
    public List<Treatment> getTreatment()
    {
        return treatmentRepository.findAll();
    }
    public Treatment createTreatment(Treatment treatment)
    {
        return treatmentRepository.save(treatment);
    }

    public void updateTreatment(String id, Treatment treatment) {

        Treatment trt= treatmentRepository.findById(id).orElse(null);
        if (trt != null) {
            trt.setAllValues(treatment);
            treatmentRepository.save(trt);
        }
    }

    public void deleteTreatment(String id)
    {
        treatmentRepository.deleteById(id);
    }
}
