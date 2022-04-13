package com.tcd.distributedsystems.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection = "ado")
public class ADO {

	@JsonSerialize(using= ToStringSerializer.class)
	@Id
	private ObjectId _id;
	private String adoName;
	private String region;
	private String adoRegistrationNumber;

	public String getAdoRegistrationNumber() {
		return adoRegistrationNumber;
	}

	public void setAdoRegistrationNumber(String adoRegistrationNumber) {
		this.adoRegistrationNumber = adoRegistrationNumber;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getAdoName() {
		return adoName;
	}

	public void setAdoName(String adoName) {
		this.adoName = adoName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
