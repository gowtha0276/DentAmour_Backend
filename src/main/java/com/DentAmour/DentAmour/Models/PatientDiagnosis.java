package com.DentAmour.DentAmour.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "PatientDiagnosis")
public class PatientDiagnosis {
    @Id
    private String id;
    private String patientId;
    private List<Treatment> treatments;
    private Doctor primaryDoctor;
    private Doctor secondaryDoctor;
    private String primaryDoctorComments;
    private String secondaryDoctorComments;
    private Date date;
    public void setAllValues(PatientDiagnosis source) {
        Class<?> modelClass = this.getClass();

        for (Field field : modelClass.getDeclaredFields()) {
            if(field.getName()=="id") continue;
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                field.set(this, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                // Handle any exceptions that may occur
            }
        }
    }
}
