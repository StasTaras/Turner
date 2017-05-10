package com.stasstudio.turner.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stasstudio.turner.domain.AllWorker;
import com.stasstudio.turner.repository.WorkerScheduleRepository;

@Service
public class WorkerScheduleService {
	
	@Autowired
	WorkerScheduleRepository workerScheduleRepository;
	
	public List<AllWorker> getAll() {
		return workerScheduleRepository.findAll();
	}
} 
