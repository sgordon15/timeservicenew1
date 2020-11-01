package com.example.timeservernew.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TimeService {

    public String getTime() {
//      Date date = new Date();
//      return date.toString();
        Instant utcTime = Instant.now();
        return utcTime.toString();
//      String finalTime = utcTime.toString();
//      return finalTime;
    }

    public Long getEpochTime() {
        Date date = new Date();
        return date.getTime();
    }

    public String getTimeZone() {
        LocalDateTime timeInZone = LocalDateTime.now(TimeZone.getTimeZone("America/Chicago").toZoneId());
        System.out.println("Time in Chicago: " + timeInZone);
        return timeInZone.toString();
    }
}

//hw: create 2 new endpts:
//1. right now, getTime gets the time of the current time zone of the server, not the user.
//1. Modify getTime to return UTC.
//2. Create a new endpt that takes in a time zone and returns the time in that time zone.
