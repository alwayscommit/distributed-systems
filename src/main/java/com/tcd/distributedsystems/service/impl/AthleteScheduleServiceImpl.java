package com.tcd.distributedsystems.service.impl;

import java.util.List;

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
		athleteSchedule.setIsAssigned(false);
		return athleteScheduleRepo.save(athleteSchedule);
	}

	@Override
	public List<AthleteSchedule> findScheduleByName(String name, String region) {
		return athleteScheduleRepo.findByFirstNameLikeIgnoreCaseAndRegionIgnoreCaseOrLastNameLikeIgnoreCaseAndRegionIgnoreCase(name, region, name, region);
	}
	
	@Override
	public AthleteSchedule assignTest(AthleteSchedule athleteSchedule) {
		return athleteScheduleRepo.save(athleteSchedule);
	}
	

}
