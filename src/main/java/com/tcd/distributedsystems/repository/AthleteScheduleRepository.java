package com.tcd.distributedsystems.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcd.distributedsystems.entity.AthleteSchedule;

public interface AthleteScheduleRepository extends MongoRepository<AthleteSchedule, ObjectId> {

	List<AthleteSchedule> findByFirstNameLikeIgnoreCaseAndRegionIgnoreCaseOrLastNameLikeIgnoreCaseAndRegionIgnoreCase(String name, String region, String name2, String region2);

	List<AthleteSchedule> findByFirstNameInIgnoreCaseAndRegionIgnoreCaseOrLastNameInIgnoreCaseAndRegionIgnoreCase(
			List<String> nameList, String region, List<String> nameList2, String region2);

	List<AthleteSchedule> findByAvailabilityStartTimeBetween(LocalDateTime now, LocalDateTime plusDays);

}
