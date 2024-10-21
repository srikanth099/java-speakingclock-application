package com.codingtask.speakingclock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingtask.speakingclock.exception.InvalidTimeException;
import com.codingtask.speakingclock.service.SpeakingClockService;

@RestController
@RequestMapping("/api/clock")
public class SpeakingClockController {

    @Autowired
    private SpeakingClockService clockService;

    @GetMapping("/current")
    public String getCurrentTimeInWords() throws InvalidTimeException  {
        return clockService.convertCurrentTimeToWords();
    }

    @GetMapping("/time/{time}")
    public String getTimeInWords(@PathVariable String time) throws InvalidTimeException {
        return clockService.convertTimeToWords(time);
    }
}
