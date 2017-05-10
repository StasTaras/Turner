package com.stasstudio.turner.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.stasstudio.turner.domain.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {
	List<Request> findAll();
}
