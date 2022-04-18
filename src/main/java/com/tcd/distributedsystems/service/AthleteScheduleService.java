package com.tcd.distributedsystems.service;

import java.util.List;

import com.tcd.distributedsystems.entity.AthleteSchedule;

public interface AthleteScheduleService {
	
	public AthleteSchedule saveAthleteSchedule(AthleteSchedule athleteSchedule);

	public List<AthleteSchedule> findScheduleByName(String name, String region);
	
	AthleteSchedule assignTest(AthleteSchedule athleteSchedule);

	public void notifyMissingSchedule();

	public List<AthleteSchedule> findScheduleByListName(List<String> nameList, String region);

	public List<AthleteSchedule> assignMultipleTest(List<AthleteSchedule> athleteSchedule);

}
