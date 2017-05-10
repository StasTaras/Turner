package com.stasstudio.turner.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stasstudio.turner.mappers.SessionMapper;
import com.stasstudio.turner.services.SessionService;
import com.stasstudio.turner.session.api.SessionApiListReply;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SessionController {
	
	@Autowired
	SessionMapper sessionMapper;
	@Autowired
	SessionService sessionService;
	
	@RequestMapping(path = "/sessions/{date}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SessionApiListReply getSessions(HttpServletResponse response,
										   @PathVariable String date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curdate = new Date();
		System.out.println(date);
		String date_local = simpleDateFormat.format(curdate);
		SessionApiListReply sessionApiListReply = new SessionApiListReply();
		sessionApiListReply.sessionApi.addAll(sessionService.getAll()
				.stream()
				.filter(session -> session.getDay().toString().equals(date))
				.map(session -> sessionMapper.toApiGet(session))
				.collect(Collectors.toList()));
		return sessionApiListReply;
	}

	@RequestMapping(path = "/sessions", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SessionApiListReply getSessionsByDate() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date curdate = new Date();
		String date_local = simpleDateFormat.format(curdate);
		SessionApiListReply sessionApiListReply = new SessionApiListReply();
		sessionApiListReply.sessionApi.addAll(sessionService.getAll()
				.stream()
				.filter(session -> session.getDay().toString().equals(date_local))
				.map(session -> sessionMapper.toApiGet(session))
				.collect(Collectors.toList()));
		return sessionApiListReply;
	}
}




