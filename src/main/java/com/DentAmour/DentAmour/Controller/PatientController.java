package com.DentAmour.DentAmour.Controller;

import com.DentAmour.DentAmour.Interface.IPatientService;
import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient)
    {
        return patientService.createPatient(patient);
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getPatients()
    {
        return patientService.findAllPatients();
    }

    @PutMapping("/updatePatientById")
    public void updatePatient(@RequestParam("id") String id,@RequestBody Patient patient)  {
         patientService.updatePatientById(id,patient);
    }

    @DeleteMapping("/deletePatientByRegistrationId")
    public void deletePatient(@RequestParam("id") String id)  {
        patientService.deletePatientByRegistrationId(id);
    }

    @GetMapping("/getByRegistrationId")
    public Patient getPatientByRegistrationId(@RequestParam("id") String id)
    {
        return patientService.findPatientByRegistrationId(id);
    }

    @GetMapping("/getByEmailId")
    public Patient getPatientByEmailId(@RequestParam("id") String id)
    {
        return patientService.findPatientByEmailId(id);
    }

    @GetMapping("/getByPhoneOrRegistrationId")
    public ResponseEntity getPatientByPhoneOrRegistrationId(@RequestParam("searchInput") String searchInput)
    {
        Patient p=patientService.findPatientByPhoneOrRegistrationId(searchInput);
        return new ResponseEntity(p,p==null ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }
}
