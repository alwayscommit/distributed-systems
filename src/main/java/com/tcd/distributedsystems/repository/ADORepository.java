package com.tcd.distributedsystems.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcd.distributedsystems.entity.ADO;

public interface ADORepository extends MongoRepository<ADO, ObjectId> {

}
