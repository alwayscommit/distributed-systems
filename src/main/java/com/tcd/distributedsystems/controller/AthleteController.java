package com.tcd.distributedsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.distributedsystems.entity.Athlete;
import com.tcd.distributedsystems.service.AthleteService;

/*Used only by the administration*/
@RestController
@RequestMapping(path = "/athlete")
public class AthleteController {

	@Autowired
	private AthleteService athleteService;

	@PostMapping
	public ResponseEntity<Athlete> saveAthlete(@RequestBody Athlete athlete) {
		return ResponseEntity.status(HttpStatus.OK).body(athleteService.saveAthlete(athlete));
	}

}
