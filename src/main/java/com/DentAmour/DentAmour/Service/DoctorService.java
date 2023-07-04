package com.DentAmour.DentAmour.Service;

import com.DentAmour.DentAmour.Helper.Utility;
import com.DentAmour.DentAmour.Models.Doctor;
import com.DentAmour.DentAmour.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Utility utility;
    public int generateRandomNumber() {
        int uniqueId = utility.getRandom();
        Doctor doctor = doctorRepository.findById(Integer.toString(uniqueId)).orElse(null);
        if(doctor!=null)
            return generateRandomNumber();
        return uniqueId;
    }
    public List<Doctor> getDoctor()
    {
        return doctorRepository.findAll();
    }
    public Doctor createDoctor(Doctor doctor)
    {
        doctor.setRegistrationID(Integer.toString(generateRandomNumber()));
        return doctorRepository.save(doctor);
    }

    public void updateDoctor(String id,Doctor doctor) {

        Doctor doc= doctorRepository.findById(id).orElse(null);
        if (doc != null) {
            doc.setAllValues(doctor);
            doctorRepository.save(doc);
        }
    }

    public void deleteDoctor(String id)
    {
        doctorRepository.deleteById(id);
    }

}
