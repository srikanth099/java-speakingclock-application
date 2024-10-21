package com.codingtask.speakingclock;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.codingtask.speakingclock.controller.SpeakingClockController;
import com.codingtask.speakingclock.service.SpeakingClockService;

@WebMvcTest(SpeakingClockController.class)
public class SpeakingClockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpeakingClockService clockService;

    @Test
    public void testGetCurrentTimeInWords() throws Exception {
        when(clockService.convertCurrentTimeToWords()).thenReturn("It's ten fifteen");

        mockMvc.perform(get("/api/clock/current"))
                .andExpect(status().isOk())
                .andExpect(content().string("It's ten fifteen"));
    }

    @Test
    public void testGetTimeInWords() throws Exception {
        when(clockService.convertTimeToWords("08:34")).thenReturn("It's eight thirty-four");

        mockMvc.perform(get("/api/clock/time/08:34"))
                .andExpect(status().isOk())
                .andExpect(content().string("It's eight thirty-four"));
    }
}
