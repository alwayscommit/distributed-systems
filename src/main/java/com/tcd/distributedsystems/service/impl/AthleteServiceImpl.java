package com.tcd.distributedsystems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcd.distributedsystems.entity.Athlete;
import com.tcd.distributedsystems.repository.AthleteRepository;
import com.tcd.distributedsystems.repository.AthleteScheduleRepository;
import com.tcd.distributedsystems.service.ADOService;
import com.tcd.distributedsystems.service.AthleteService;

@Service
public class AthleteServiceImpl implements AthleteService {
	
	@Autowired
	private AthleteRepository athleteRepo;

	@Override
	public Athlete saveAthlete(Athlete athlete) {
		// TODO Auto-generated method stub
		return athleteRepo.save(athlete);
	}


}

