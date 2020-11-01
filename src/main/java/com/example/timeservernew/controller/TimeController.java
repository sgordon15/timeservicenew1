package com.example.timeservernew.controller;

import com.example.timeservernew.model.TimeResponse;
import com.example.timeservernew.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RequestMapping("/api/v1")
@RestController
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime() {
        return timeService.getTime();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime() {
        return timeService.getEpochTime();
    }

    @GetMapping("/timeZone")
    public String getTimeZone() {
        return timeService.getTimeZone("America/Chicago");
    }

    @GetMapping("/getTime")
    public TimeResponse getTimeResponse() {
        return timeService.getTimeResponse();
    }
}
