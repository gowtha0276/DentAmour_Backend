package com.DentAmour.DentAmour.Repository;
import com.DentAmour.DentAmour.Models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {
    Patient findByregistrationID(String registrationID);
}
