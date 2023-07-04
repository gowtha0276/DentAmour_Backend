package com.DentAmour.DentAmour.Repository;
import com.DentAmour.DentAmour.Models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {
}
