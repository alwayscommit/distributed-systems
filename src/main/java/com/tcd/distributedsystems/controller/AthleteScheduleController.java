package com.tcd.distributedsystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.distributedsystems.entity.AthleteSchedule;
import com.tcd.distributedsystems.service.AthleteScheduleService;

@RestController
@RequestMapping(path = "/athleteSchedule")
public class AthleteScheduleController {

	@Autowired
	private AthleteScheduleService athleteScheduleService;

	@PostMapping
	public ResponseEntity<AthleteSchedule> saveAthleteSchedule(@RequestBody AthleteSchedule athleteSchedule) {
		return ResponseEntity.status(HttpStatus.OK).body(athleteScheduleService.saveAthleteSchedule(athleteSchedule));
	}

	@GetMapping(path = "/findScheduleByName")
	public List<AthleteSchedule> queryAthleteSchedule(@RequestParam String name, @RequestParam String region) {
		return athleteScheduleService.findScheduleByName(name, region);
	}
	
	@PutMapping(path = "/assignTest")
	public ResponseEntity<AthleteSchedule> assignTest(@RequestBody AthleteSchedule athleteSchedule) {
		return ResponseEntity.status(HttpStatus.OK).body(athleteScheduleService.assignTest(athleteSchedule));
	}

}
