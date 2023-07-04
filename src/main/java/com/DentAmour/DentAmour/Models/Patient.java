package com.DentAmour.DentAmour.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "Patient")
public class Patient {
    @Id
    private String id;
    private String name;
    private String registrationID;
    private String dateOfBirth;
    private String occupation;
    private String address;
    private String mail;
    private String phone;
    private int age;

    @Autowired
    private RestTemplate restTemplatel;
    @Bean
    public void setAllValues(Patient source) {
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
