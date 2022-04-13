package com.tcd.distributedsystems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcd.distributedsystems.entity.AthleteSchedule;
import com.tcd.distributedsystems.repository.AthleteScheduleRepository;
import com.tcd.distributedsystems.service.AthleteScheduleService;

@Service
public class AthleteScheduleServiceImpl implements AthleteScheduleService {
	
	@Autowired
	private AthleteScheduleRepository athleteScheduleRepo;

	@Override
	public AthleteSchedule saveAthleteSchedule(AthleteSchedule athleteSchedule) {
		return athleteScheduleRepo.save(athleteSchedule);
	}

}

