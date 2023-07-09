package com.DentAmour.DentAmour.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.DentAmour.DentAmour.Models.PatientDiagnosis;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientDiagnosisRepository  extends MongoRepository<PatientDiagnosis,String> {

}
