package com.stasstudio.turner.rest;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stasstudio.turner.mappers.WorkerScheduleMapper;
import com.stasstudio.turner.services.WorkerScheduleService;
import com.stasstudio.turner.workerschedule.api.WorkerScheduleApiListReply;

@RestController
public class WorkerScheduleController {
	
	@Autowired
	WorkerScheduleMapper workerScheduleMapper;
	@Autowired
	WorkerScheduleService workerScheduleService;
	
	@RequestMapping(path = "/workers", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WorkerScheduleApiListReply getWorkerSchedule() {
		WorkerScheduleApiListReply workerScheduleApiListReply = new WorkerScheduleApiListReply();
		workerScheduleApiListReply.workerSchedule.addAll(workerScheduleService.getAll()
				.stream()
				.map(worker -> workerScheduleMapper.toApiGet(worker))
				.collect(Collectors.toList()));
		return workerScheduleApiListReply;
	}	
}
