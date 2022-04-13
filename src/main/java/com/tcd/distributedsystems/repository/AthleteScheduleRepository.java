package com.tcd.distributedsystems.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcd.distributedsystems.entity.AthleteSchedule;

public interface AthleteScheduleRepository extends MongoRepository<AthleteSchedule, ObjectId> {

	List<AthleteSchedule> findByFirstNameLikeAndRegion(String name, String region);

	List<AthleteSchedule> findByFirstNameLikeIgnoreCaseAndRegionIgnoreCase(String name, String region);

}
