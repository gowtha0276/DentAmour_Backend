package com.DentAmour.DentAmour.Controller;

import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient)
    {
        return patientService.createPatient(patient);
    }
    @GetMapping("/get")
    public List<Patient> getPatient()
    {
        return patientService.getPatient();
    }

    @PutMapping("/update")
    public void updatePatient(@RequestParam("id") String param1,@RequestBody Patient patient)  {
         patientService.updatePatient(param1,patient);
    }

    @DeleteMapping("/delete")
    public void deletePatient(@RequestParam("id") String param1)  {
        patientService.deletePatient(param1);
    }

}
