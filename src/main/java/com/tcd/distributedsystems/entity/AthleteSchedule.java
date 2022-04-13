package com.tcd.distributedsystems.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tcd.distributedsystems.model.Location;

@Document(collection = "athleteSchedule")
public class AthleteSchedule {

	@JsonSerialize(using= ToStringSerializer.class)
	@Id
	private ObjectId _id;

	private String athleteId;
	private String firstName;
	private String lastName;
	private Location location;
	private LocalDateTime availabilityStartTime;
	private LocalDateTime availabilityEndTime;
	private Boolean isAssigned;
	private String region;

	public LocalDateTime getAvailabilityStartTime() {
		return availabilityStartTime;
	}

	public void setAvailabilityStartTime(LocalDateTime availabilityStartTime) {
		this.availabilityStartTime = availabilityStartTime;
	}

	public LocalDateTime getAvailabilityEndTime() {
		return availabilityEndTime;
	}

	public void setAvailabilityEndTime(LocalDateTime availabilityEndTime) {
		this.availabilityEndTime = availabilityEndTime;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(String athleteId) {
		this.athleteId = athleteId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

}
