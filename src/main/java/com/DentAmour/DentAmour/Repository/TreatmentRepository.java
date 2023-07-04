package com.DentAmour.DentAmour.Repository;
import com.DentAmour.DentAmour.Models.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends MongoRepository<Treatment,String> {
}