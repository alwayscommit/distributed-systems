package com.tcd.distributedsystems.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcd.distributedsystems.entity.AthleteSchedule;

public interface AthleteScheduleRepository extends MongoRepository<AthleteSchedule, ObjectId>{

}
