package com.stasstudio.turner.mappers;

import org.springframework.stereotype.Component;
import com.stasstudio.turner.domain.Request;
import com.stasstudio.turner.request.api.RequestApi;

@Component
public class RequestMapper {
	public RequestApi toApiGet(Request request) {
		RequestApi requestApi = null;
		if(request != null){
			requestApi = new RequestApi();
			requestApi.isdone = request.getIsdone();
			requestApi.whencreate = request.getWhencreate();
			requestApi.whendone = request.getWhendone();	
			requestApi.content = request.getContent();
			requestApi.priority = request.getPriority();
			if(request.getAllWorker().getWorker() == null){
				requestApi.author_name = request.getAllWorker().getName();
			}
			else{
				requestApi.author_name = request.getAllWorker().getWorker().getName();
			}

		}
		return requestApi;
	}
}
