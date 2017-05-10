package com.stasstudio.turner.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stasstudio.turner.domain.Request;
import com.stasstudio.turner.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired 
	RequestRepository requestRepository;
	
	public List<Request> getAll() {
		return requestRepository.findAll();
	}
	
}
