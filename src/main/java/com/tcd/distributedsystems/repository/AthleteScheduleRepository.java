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

	List<AthleteSchedule> findByFirstNameLikeIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetweenOrLastNameLikeIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetween(
			String name, String region, LocalDateTime now, LocalDateTime plusDays, String name2, String region2,
			LocalDateTime now2, LocalDateTime plusDays2);

	List<AthleteSchedule> findByFirstNameInIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetweenOrLastNameInIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetween(
			List<String> nameList, String region, LocalDateTime now, LocalDateTime plusDays, List<String> nameList2,
			String region2, LocalDateTime now2, LocalDateTime plusDays2);

}
