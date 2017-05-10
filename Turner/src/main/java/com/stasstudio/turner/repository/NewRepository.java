package com.stasstudio.turner.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.stasstudio.turner.domain.New;

public interface NewRepository extends CrudRepository<New, Integer> {
	@Override
	List<New> findAll();
}
