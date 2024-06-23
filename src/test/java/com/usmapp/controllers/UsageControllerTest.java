package com.usmapp.controllers;

import com.usmapp.controller.UsageController;
import com.usmapp.service.UsageDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UsageControllerTest {

    @Mock
    private UsageDataService usageDataService;

    @InjectMocks
    private UsageController usageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCurrentCycleDailyUsageData() {
        String userId = "testUser";
        String mdn = "testMdn";

        Map<Date, Number> mockUsageData = new HashMap<>();
        mockUsageData.put(new Date(), 100);

        when(usageDataService.getCurrentCycleDailyUsageData(anyString(), anyString())).thenReturn(mockUsageData);

        ResponseEntity<?> responseEntity = usageController.getCurrentCycleDailyUsageData(userId, mdn);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUsageData, responseEntity.getBody());
    }
}
