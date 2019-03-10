package com.example.tddexamples;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Main {

        private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a z";

        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        @Test
        public void zoneTime()
        {
            ZoneId fromTimeZone = ZoneId.of("Asia/Kolkata");    //Source timezone
            ZoneId toTimeZone = ZoneId.of("America/New_York");  //Target timezone

            LocalDateTime today = LocalDateTime.now();          //Current time

            //Zoned date time at source timezone
            ZonedDateTime currentISTime = today.atZone(fromTimeZone);

            //Zoned date time at target timezone
            ZonedDateTime currentETime = currentISTime.withZoneSameInstant(toTimeZone);

            //Format date time - optional
            System.out.println("Indian Time Zone :  "+formatter.format(currentISTime));
            System.out.println("Us  Time   Zone  :  "+formatter.format(currentETime));
        }


        @Test
       public void dateBetweenTimezones()
        {
             SimpleDateFormat FORMATTER = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mma z");


                TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York"); //Target timezone

                Date currentDate = new Date();

                System.out.println(FORMATTER.format(currentDate));  //Date in current timezone

                FORMATTER.setTimeZone(etTimeZone);

                System.out.println(FORMATTER.format(currentDate));  //Date in target timezone

        }
    }

