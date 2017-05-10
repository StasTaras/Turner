package com.stasstudio.turner.mappers;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import com.stasstudio.turner.domain.Schedule;
import com.stasstudio.turner.schedule.api.ScheduleApi;

@Component
public class ScheduleMapper {
	public ScheduleApi toApiGet(Schedule schedule) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String timeStart = null;
		String timeFinish = null;
		String dateStart = null;
		ScheduleApi scheduleApi = null;
		if(schedule != null){
			scheduleApi = new ScheduleApi();
			scheduleApi.workplaceName = schedule.getWorkplace().getName();
			if(schedule.getAllWorker().getWorker() != null){
				scheduleApi.workersName = schedule.getAllWorker().getWorker().getName();
			} else{
				scheduleApi.workersName = schedule.getAllWorker().getName();
			}
			dateStart = simpleDateFormat.format(schedule.getStarttime());
			scheduleApi.startDate = dateStart;
			timeStart = simpleTimeFormat.format(schedule.getStarttime());
			scheduleApi.startTime = timeStart;
			timeFinish = simpleTimeFormat.format(schedule.getFinishtime());
			scheduleApi.finishTime = timeFinish;
		}
		return scheduleApi;
	}
}
