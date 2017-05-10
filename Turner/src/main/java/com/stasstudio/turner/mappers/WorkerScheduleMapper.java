package com.stasstudio.turner.mappers;

import org.springframework.stereotype.Component;
import com.stasstudio.turner.domain.AllWorker;
import com.stasstudio.turner.workerschedule.api.WorkerScheduleApi;

@Component
public class WorkerScheduleMapper {
	public WorkerScheduleApi toApiGet(AllWorker allWorker) {
		WorkerScheduleApi workerScheduleApi = null;
		if(allWorker != null){
			workerScheduleApi = new WorkerScheduleApi();
			workerScheduleApi.id = allWorker.getWorker().getIdWorker();
			if(allWorker.getName() == null){
				workerScheduleApi.name = allWorker.getWorker().getName();
			}else {
				workerScheduleApi.name = allWorker.getName();
			}
		}
		return workerScheduleApi;
	}
}
