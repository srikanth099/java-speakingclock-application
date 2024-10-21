package com.codingtask.speakingclock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codingtask.speakingclock.exception.InvalidTimeException;

@Service
public class SpeakingClockService {

    private static final Map<Integer, String> HOURS = new HashMap<>();
    private static final Map<Integer, String> MINUTES = new HashMap<>();

    static {
        // Populate HOURS map
        HOURS.put(0, "midnight");
        HOURS.put(12, "midday");
        HOURS.put(1, "one");
        HOURS.put(2, "two");
        HOURS.put(3, "three");
        HOURS.put(4, "four");
        HOURS.put(5, "five");
        HOURS.put(6, "six");
        HOURS.put(7, "seven");
        HOURS.put(8, "eight");
        HOURS.put(9, "nine");
        HOURS.put(10, "ten");
        HOURS.put(11, "eleven");

        // Populate MINUTES map
        MINUTES.put(0, "o'clock");
        MINUTES.put(1, "one");
        MINUTES.put(2, "two");
        MINUTES.put(3, "three");
        MINUTES.put(4, "four");
        MINUTES.put(5, "five");
        MINUTES.put(6, "six");
        MINUTES.put(7, "seven");
        MINUTES.put(8, "eight");
        MINUTES.put(9, "nine");
        MINUTES.put(10, "ten");
        MINUTES.put(11, "eleven");
        MINUTES.put(12, "twelve");
        MINUTES.put(13, "thirteen");
        MINUTES.put(14, "fourteen");
        MINUTES.put(15, "fifteen");
        MINUTES.put(16, "sixteen");
        MINUTES.put(17, "seventeen");
        MINUTES.put(18, "eighteen");
        MINUTES.put(19, "nineteen");
        MINUTES.put(20, "twenty");
        MINUTES.put(21, "twenty-one");
        MINUTES.put(22, "twenty-two");
        MINUTES.put(23, "twenty-three");
        MINUTES.put(24, "twenty-four");
        MINUTES.put(25, "twenty-five");
        MINUTES.put(26, "twenty-six");
        MINUTES.put(27, "twenty-seven");
        MINUTES.put(28, "twenty-eight");
        MINUTES.put(29, "twenty-nine");
        MINUTES.put(30, "thirty");
        MINUTES.put(31, "thirty-one");
        MINUTES.put(32, "thirty-two");
        MINUTES.put(33, "thirty-three");
        MINUTES.put(34, "thirty-four");
        MINUTES.put(35, "thirty-five");
        MINUTES.put(36, "thirty-six");
        MINUTES.put(37, "thirty-seven");
        MINUTES.put(38, "thirty-eight");
        MINUTES.put(39, "thirty-nine");
        MINUTES.put(40, "forty");
        MINUTES.put(41, "forty-one");
        MINUTES.put(42, "forty-two");
        MINUTES.put(43, "forty-three");
        MINUTES.put(44, "forty-four");
        MINUTES.put(45, "forty-five");
        MINUTES.put(46, "forty-six");
        MINUTES.put(47, "forty-seven");
        MINUTES.put(48, "forty-eight");
        MINUTES.put(49, "forty-nine");
        MINUTES.put(50, "fifty");
        MINUTES.put(51, "fifty-one");
        MINUTES.put(52, "fifty-two");
        MINUTES.put(53, "fifty-three");
        MINUTES.put(54, "fifty-four");
        MINUTES.put(55, "fifty-five");
        MINUTES.put(56, "fifty-six");
        MINUTES.put(57, "fifty-seven");
        MINUTES.put(58, "fifty-eight");
        MINUTES.put(59, "fifty-nine");
    }

    public String convertCurrentTimeToWords() throws InvalidTimeException {
        LocalTime now = LocalTime.now();
        return convertTimeToWords(now.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public String convertTimeToWords(String time) throws InvalidTimeException {
        try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            int hour = localTime.getHour();
            int minute = localTime.getMinute();

            // Handle special cases for Midnight and Midday
            if (hour == 0 && minute == 0) {
                return "It's Midnight";
            } else if (hour == 12 && minute == 0) {
                return "It's Midday";
            } else {
                String hourInWords = HOURS.getOrDefault(hour % 12 == 0 ? 12 : hour % 12, "");
                String minuteInWords = MINUTES.getOrDefault(minute, "");
                return "It's " + hourInWords + " " + minuteInWords;
            }
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid time format: " + time);
        }
    }
}
