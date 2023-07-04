package com.DentAmour.DentAmour.Controller;
import com.DentAmour.DentAmour.Models.Doctor;
import com.DentAmour.DentAmour.Models.Patient;
import com.DentAmour.DentAmour.Service.DoctorService;
import com.DentAmour.DentAmour.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.createDoctor(doctor);
    }
    @GetMapping("/get")
    public List<Doctor> getDoctor()
    {
        return doctorService.getDoctor();
    }

    @PutMapping("/update")
    public void updateDoctor(@RequestParam("id") String param1,@RequestBody Doctor doctor)  {
        doctorService.updateDoctor(param1,doctor);
    }

    @DeleteMapping("/delete")
    public void deleteDoctor(@RequestParam("id") String param1)  {
        doctorService.deleteDoctor(param1);
    }

}
