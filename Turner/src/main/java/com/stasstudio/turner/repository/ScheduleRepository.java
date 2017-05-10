package com.stasstudio.turner.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.stasstudio.turner.domain.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
	@Override
	List<Schedule> findAll();
	Schedule findScheduleByIdSchedule(Integer id);
}
