package com.stasstudio.turner.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stasstudio.turner.domain.New;
import com.stasstudio.turner.repository.NewRepository;

@Service
public class NewsService {
	
	@Autowired
	NewRepository newRepository;
	
	public List<New> getAll() {
		return newRepository.findAll();
	}
}
