package com.usmapp.controller;

import com.usmapp.entity.UsageData;
import com.usmapp.service.UsageDataService;

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
@RequestMapping("/service/usage/")
public class UsageController {
	
	private static final Logger log = LoggerFactory.getLogger(UsageController.class);

    @Autowired
    private UsageDataService usageDataService;

    @GetMapping("/getCurrentCycleDailyUsageData")
	public ResponseEntity<?> getCurrentCycleDailyUsageData(@RequestParam String userId, @RequestParam String mdn) {
    	
		log.info("getCurrentCycleDailyUsageData request : userId : {} mdn : {}", userId, mdn);

		Map<Date, Number> map = usageDataService.getCurrentCycleDailyUsageData(mdn, userId);
		
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

}
