package com.usmapp.repository;

import com.usmapp.entity.UsageData;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageDataRepository extends MongoRepository<UsageData, String> {
	
	@Query("{userId:'?0'}, {mdn:'?1'}, {date:'?2'}")
	List<UsageData> getUsageDataOfDate(String userId, String mdn);
	
	@Query("{userId:'?0'}, {mdn:'?1'}")
	List<UsageData> getUsageDataOfCycle(String userId, String mdn, String cycleId); // get data order by date
	
}
