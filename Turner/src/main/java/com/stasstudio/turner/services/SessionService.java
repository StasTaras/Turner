package com.stasstudio.turner.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stasstudio.turner.domain.Session;
import com.stasstudio.turner.repository.SessionRepository;

@Service
public class SessionService {

	@Autowired
	SessionRepository sessionRepository;
	
	public List<Session> getAll() {
		return sessionRepository.findAll();
	}
}
