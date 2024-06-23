package com.usmapp.controller;

import com.usmapp.entity.CycleData;
import com.usmapp.service.CycleDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CycleControllerTest {

    @Mock
    private CycleDataService cycleDataService;

    @InjectMocks
    private CycleController cycleController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserCycleHistory() throws ParseException {
        String userId = "testUser";
        String mdn = "testMdn";

        List<CycleData> cycleDataList = new ArrayList<>();
        CycleData cycleData = new CycleData();
        cycleData.setId("testCycleId");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cycleData.setStartDate(sdf.parse("2024-01-01"));
        cycleData.setEndDate(sdf.parse("2024-01-31"));

        cycleDataList.add(cycleData);

        Map<String, List<CycleData>> mockCycleDataMap = new HashMap<>();
        mockCycleDataMap.put("testCycleId", cycleDataList);

        when(cycleDataService.getUserCycleHistory(anyString(), anyString())).thenReturn(null);

        ResponseEntity<?> responseEntity = cycleController.getUserCycleHistory(userId, mdn);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockCycleDataMap, responseEntity.getBody());
    }

    @Test
    void testGetUserCycleHistory_InternalServerError() {
        when(cycleDataService.getUserCycleHistory(anyString(), anyString())).thenThrow(new RuntimeException("Exception"));

        String userId = "testUser";
        String mdn = "testMdn";

        ResponseEntity<?> responseEntity = cycleController.getUserCycleHistory(userId, mdn);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}
