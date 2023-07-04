package com.DentAmour.DentAmour.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Field;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Treatment")
public class Treatment {
    @Id
    private String id;
    private String name;
    private String textInput;
    private String stepTreatment;
    private String multipleStep;

    public void setAllValues(Treatment source) {
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
