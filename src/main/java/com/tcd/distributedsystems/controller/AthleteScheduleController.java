package com.tcd.distributedsystems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
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
		if ((athleteSchedule.getAvailabilityEndTime().getHour()
				- athleteSchedule.getAvailabilityStartTime().getHour()) < 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(athleteSchedule);
		}

		return ResponseEntity.status(HttpStatus.OK).body(athleteScheduleService.saveAthleteSchedule(athleteSchedule));
	}

	@GetMapping(path = "/findScheduleByName")
	public List<AthleteSchedule> queryAthleteSchedule(@RequestParam String name, @RequestParam String region) {
		return athleteScheduleService.findScheduleByName(name, region);
	}

	@GetMapping(path = "/findScheduleByListName")
	public List<AthleteSchedule> queryAthleteSchedule(@RequestParam List<String> nameList,
			@RequestParam String region) {
		return athleteScheduleService.findScheduleByListName(nameList, region);
	}

	@PutMapping(path = "/assignMultipleTest")
	public ResponseEntity<String> assignMultipleTest(@RequestBody List<AthleteSchedule> athleteScheduleList) {

		List<String> failedAssignments = new ArrayList<String>();
		for (AthleteSchedule schedule : athleteScheduleList) {
			try {
				athleteScheduleService.assignTest(schedule);
			} catch (OptimisticLockingFailureException exception) {
				failedAssignments.add(schedule.getFirstName() + " " + schedule.getLastName() + "");
				continue;
			}
		}
		if (!failedAssignments.isEmpty()) {
			return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
					.body("Unable to assign tests to athletes :: " + String.join(",", failedAssignments)
							+ ". Please check if they have been already assigned a test.");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Successfully assigned tests to all selected athletes!");
	}

	@PutMapping(path = "/assignTest")
	public ResponseEntity<String> assignTest(@RequestBody AthleteSchedule athleteSchedule) {
		try {
			athleteScheduleService.assignTest(athleteSchedule);
			return ResponseEntity.status(HttpStatus.OK).body("Assigned Test Succesfully!");
		} catch (OptimisticLockingFailureException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to assign test to athlete. Please check if the athlete"
							+ "has already been assigned a test!");
		}

	}

	@GetMapping(path = "/notifyMissingSchedule")
	public ResponseEntity notifyMissingSchedule() {
		athleteScheduleService.notifyMissingSchedule();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// search schedule by pin code
	// search schedule by city
	// assign tests to multiple athletes
}
