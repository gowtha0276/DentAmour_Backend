package com.DentAmour.DentAmour.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Field;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Doctor")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String registrationID;
    private String designation;
    private String mail;
    private String phone;

    public void setAllValues(Doctor source) {
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
