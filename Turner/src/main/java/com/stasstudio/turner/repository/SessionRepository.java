package com.stasstudio.turner.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.stasstudio.turner.domain.Session;

public interface SessionRepository extends CrudRepository<Session, Integer>{
	@Override
	List<Session> findAll();
}
