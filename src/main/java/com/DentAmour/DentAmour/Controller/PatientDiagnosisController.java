package com.DentAmour.DentAmour.Controller;

import com.DentAmour.DentAmour.Interface.IPatientDiagnosisService;
import com.DentAmour.DentAmour.Models.PatientDiagnosis;
import com.DentAmour.DentAmour.Models.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patientDiagnosis")
public class PatientDiagnosisController {

    @Autowired
    private IPatientDiagnosisService patientDiagnosisService;

    @PostMapping("/create")
    public PatientDiagnosis createTreatment(@RequestBody PatientDiagnosis patientDiagnosis)
    {
        return patientDiagnosisService.createPatientDiagnosis(patientDiagnosis);
    }
}
