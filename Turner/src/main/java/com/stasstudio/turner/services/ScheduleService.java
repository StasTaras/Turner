package com.stasstudio.turner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stasstudio.turner.domain.Schedule;
import com.stasstudio.turner.repository.ScheduleRepository;




@Service
public class ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	//DownloadExelFile download = new DownloadExelFile();

	public List<Schedule> getAll() {
		return scheduleRepository.findAll();
	}
	public Schedule getById(Integer id) {
		return scheduleRepository.findScheduleByIdSchedule(id);
	}
}
