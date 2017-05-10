package com.stasstudio.turner.rest;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stasstudio.turner.mappers.RequestMapper;
import com.stasstudio.turner.request.api.RequestApiListReply;
import com.stasstudio.turner.services.RequestService;

@RestController
public class RequestController {
	
	@Autowired
	RequestMapper requestMapper;
	
	@Autowired
	RequestService requestService;
	
	@RequestMapping(path = "/requests", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RequestApiListReply getAllrequests() {
		RequestApiListReply requestList = new RequestApiListReply();
		requestList.requestApi.addAll(requestService.getAll()
				.stream()
				.map(request -> requestMapper.toApiGet(request))
				.collect(Collectors.toList()));
		return requestList;
	}
}
