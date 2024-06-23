package com.usmapp.service;

import com.usmapp.entity.UsageData;
import com.usmapp.repository.UsageDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsageDataService {

	private static final Logger log = LoggerFactory.getLogger(UsageDataService.class);

	private final UsageDataRepository usageDataRepository;

	@Autowired
	public UsageDataService(UsageDataRepository usageDataRepository) {
		this.usageDataRepository = usageDataRepository;
	}

	/**
	 * Retrieves the daily usage data for the current cycle of a user and their mobile device number (mdn).
	 *
	 * @param userId The ID of the user.
	 * @param mdn The mobile device number of the user.
	 * @return A map containing dates as keys and usage data (in MB) as values.
	 */
	public Map<Date, Number> getCurrentCycleDailyUsageData(String userId, String mdn) {
		Map<Date, Number> dailyUsageMap = new HashMap<>();
		try {
			List<UsageData> usageDataList = usageDataRepository.getUsageDataOfDate(userId, mdn);
			if (!usageDataList.isEmpty()) {
				for (UsageData data : usageDataList) {
					dailyUsageMap.put(data.getUsageDate(), data.getUsedInMb());
				}
				log.info("Usage data for user: {} mdn: {} current days: {}", userId, mdn, dailyUsageMap.size());
			} else {
				log.info("User does not have active usage for the cycle.");
			}
		} catch (Exception e) {
			log.error("Error fetching usage data for user: {} mdn: {}", userId, mdn, e);
		}
		return dailyUsageMap;
	}
}
