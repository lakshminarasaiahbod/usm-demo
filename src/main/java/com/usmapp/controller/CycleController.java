package com.usmapp.controller;

import com.usmapp.entity.CycleData;
import com.usmapp.service.CycleDataService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CycleController {
	
	private static final Logger log = LoggerFactory.getLogger(CycleController.class);

    @Autowired
    private CycleDataService cycleDataService;

    @GetMapping("/getUserCycleHistory")
	public ResponseEntity<?> getUserCycleHistory(@RequestParam String userId, @RequestParam String mdn) {
    	
		log.info("getUserCycleHistory request : userId : {} mdn : {}", userId, mdn);

		Map<String, List> list = cycleDataService.getUserCycleHistory(mdn, userId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
