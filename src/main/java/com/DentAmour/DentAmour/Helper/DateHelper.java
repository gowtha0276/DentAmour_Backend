package com.DentAmour.DentAmour.Helper;

import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.Date;

@Component
public class DateHelper {


   public Date nowInIST(){
       return new Date(System.currentTimeMillis());
   }

   public Date nowInGMT(){
       return new Date(String.valueOf(nowInIST().toInstant().atZone(ZoneOffset.UTC).toInstant()));
   }
}
