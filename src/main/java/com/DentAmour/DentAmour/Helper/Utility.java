package com.DentAmour.DentAmour.Helper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class Utility {
    public int calculateAge(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime dateTime = LocalDateTime.parse(dateOfBirth, formatter);
        LocalDate dob = dateTime.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }

    public int getRandom()
    {
        Random random = new Random();
        int uniqueId = random.nextInt(100000);
        return  uniqueId;
    }
}
