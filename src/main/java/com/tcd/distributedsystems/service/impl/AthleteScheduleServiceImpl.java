package com.tcd.distributedsystems.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return athleteScheduleRepo
				.findByFirstNameLikeIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetweenOrLastNameLikeIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetween(
						name, region, LocalDateTime.now(), LocalDateTime.now().plusDays(7), name, region,
						LocalDateTime.now(), LocalDateTime.now().plusDays(7));
	}

	@Override
	public AthleteSchedule assignTest(AthleteSchedule athleteSchedule) {
		return athleteScheduleRepo.save(athleteSchedule);
	}

	@Override
	public void notifyMissingSchedule() {
		List<AthleteSchedule> athleteScheduleList = athleteScheduleRepo
				.findByAvailabilityStartTimeBetween(LocalDateTime.now(), LocalDateTime.now().plusDays(7));
		System.out.println(athleteScheduleList);

		Map<String, List<AthleteSchedule>> scheduleMap = new HashMap<String, List<AthleteSchedule>>();

		for (AthleteSchedule schedule : athleteScheduleList) {
			String athleteId = schedule.getAthleteId();
			if (scheduleMap.containsKey(athleteId)) {
				List<AthleteSchedule> scheduleList = scheduleMap.get(athleteId);
				scheduleList.add(schedule);
			} else {
				List<AthleteSchedule> scheduleList = new ArrayList<AthleteSchedule>();
				scheduleList.add(schedule);
				scheduleMap.put(athleteId, scheduleList);
			}
		}

		for (String key : scheduleMap.keySet()) {
			if (scheduleMap.get(key).size() < 7) {
				System.out.println("Notify AthleteId " + key + " to fill the whereabouts for this week!");
			}
		}

		System.out.println(scheduleMap);

	}

	@Override
	public List<AthleteSchedule> findScheduleByListName(List<String> nameList, String region) {
		return athleteScheduleRepo
				.findByFirstNameInIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetweenOrLastNameInIgnoreCaseAndRegionIgnoreCaseAndAvailabilityStartTimeBetween(
						nameList, region, LocalDateTime.now(), LocalDateTime.now().plusDays(7), nameList, region,
						LocalDateTime.now(), LocalDateTime.now().plusDays(7));
	}

	@Override
	public List<AthleteSchedule> assignMultipleTest(List<AthleteSchedule> athleteSchedule) {
		return athleteScheduleRepo.saveAll(athleteSchedule);
	}

}
