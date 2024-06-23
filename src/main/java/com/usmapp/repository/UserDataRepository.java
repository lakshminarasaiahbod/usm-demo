package com.usmapp.repository;

import com.usmapp.entity.UserData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends MongoRepository<UserData, String> {
	
}
