package com.example.timeservernew.service;

import com.example.timeservernew.model.TimeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TimeService {

    public String getTime() {
        Instant utcTime = Instant.now();
        return utcTime.toString();
    }

    public Long getEpochTime() {
        Date date = new Date();
        return date.getTime();
    }


    public String getTimeZone(String timeZone) {
        TimeZone zone = TimeZone.getTimeZone(timeZone);
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'ZZZ");
        dateformat.setTimeZone(zone);
        return dateformat.format(new Date());
    }

    public TimeResponse getTimeResponse() {
        Date date = new Date();
        return TimeResponse.builder()
                .localTime(date.toString())
                .epochMillis(date.getTime())
                .utcTime(getUtcDateFromLocalDate(date))
                .build();
    }

    private String getUtcDateFromLocalDate(Date date) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(zone);
        return dateFormat.format(date);
    }
}

