package com.usmapp.repository;

import com.usmapp.entity.CycleData;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleDataRepository extends MongoRepository<CycleData, String> {
	
	@Query("{userId:'?0'}, {mdn:'?1'}")
	List<CycleData> findUserCycles(String userId, String mdn);
	
	@Query("{userId:'?0'}, {mdn:'?1'}")
	Optional<CycleData> getLatestCycleData(String userId, String mdn);
	
}
