package com.DentAmour.DentAmour.Controller;

import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Models.Treatment;
import com.DentAmour.DentAmour.Service.PatientService;
import com.DentAmour.DentAmour.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;
    @PostMapping("/create")
    public Treatment createTreatment(@RequestBody Treatment treatment)
    {
        return treatmentService.createTreatment(treatment);
    }
    @GetMapping("/getAllTreatments")
    public ResponseEntity getTreatment()
    {
        return new ResponseEntity(treatmentService.getTreatment(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void updateTreatment(@RequestParam("id") String param1,@RequestBody Treatment treatment)  {
        treatmentService.updateTreatment(param1,treatment);
    }

    @DeleteMapping("/delete")
    public void deleteTreatment(@RequestParam("id") String param1)  {
        treatmentService.deleteTreatment(param1);
    }
}
