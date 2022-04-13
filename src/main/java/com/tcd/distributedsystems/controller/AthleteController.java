package com.tcd.distributedsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.distributedsystems.entity.Athlete;
import com.tcd.distributedsystems.entity.AthleteSchedule;
import com.tcd.distributedsystems.service.AthleteService;

/*Used only by the administration*/
@RestController
@RequestMapping(path = "/athlete")
public class AthleteController {

	@Autowired
	private AthleteService athleteService;

	@PostMapping
	public Athlete saveAthlete(@RequestBody Athlete athlete) {
		return athleteService.saveAthlete(athlete);
	}

}
