package com.tcd.distributedsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.distributedsystems.entity.AthleteSchedule;
import com.tcd.distributedsystems.service.AthleteScheduleService;

@RestController
@RequestMapping(path = "/athleteSchedule")
public class AthleteScheduleController {

	@Autowired
	private AthleteScheduleService athleteScheduleService;

	@PostMapping
	public AthleteSchedule saveAthleteSchedule(@RequestBody AthleteSchedule athleteSchedule) {
		return athleteScheduleService.saveAthleteSchedule(athleteSchedule);
	}

}
