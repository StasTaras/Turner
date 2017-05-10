package com.stasstudio.turner.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.stasstudio.turner.domain.AllWorker;

public interface WorkerScheduleRepository extends CrudRepository<AllWorker, Integer> {
	@Override
	List<AllWorker> findAll();
}
