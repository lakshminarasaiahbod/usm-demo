package com.usmapp.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmapp.entity.CycleData;
import com.usmapp.repository.CycleDataRepository;

@Service
public class CycleDataService {

	private static final Logger log = LoggerFactory.getLogger(CycleDataService.class);

	@Autowired
	private CycleDataRepository cycleDataRepository;

	/**
	 * Retrieves the cycle history for a user and their mobile device number (mdn).
	 *
	 * @param userId The ID of the user.
	 * @param mdn The mobile device number of the user.
	 * @return A map containing cycle IDs as keys and lists of cycle start and end dates as values.
	 */
	public Map<String, List> getUserCycleHistory(String userId, String mdn) {
		// Retrieve list of cycles for the user from the repository
		List<CycleData> listOfCycles = cycleDataRepository.findUserCycles(userId, mdn);

		// Initialize a map to store cycle data
		Map<String, List> cyclesMap = new HashMap<>();

		// Check if the list of cycles is not empty
		if (!listOfCycles.isEmpty()) {
			// Iterate through each cycle data and add to the map
			for (CycleData cycleData : listOfCycles) {
				List<Date> listOfEntries = new ArrayList<>();
				listOfEntries.add(cycleData.getStartDate());
				listOfEntries.add(cycleData.getEndDate());

				// Store the list of dates with the cycle ID as the key
				cyclesMap.put(cycleData.getId(), listOfEntries);
			}
		}

		// Log the count of cycles found for the user
		log.info("CycleHistory count of user: {} mdn: {} is {}", userId, mdn, cyclesMap.size());

		return cyclesMap;
	}
}
