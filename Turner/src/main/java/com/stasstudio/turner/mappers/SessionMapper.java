package com.stasstudio.turner.mappers;

import org.springframework.stereotype.Component;
import com.stasstudio.turner.domain.Session;
import com.stasstudio.turner.session.api.SessionApi;

@Component
public class SessionMapper {
	public SessionApi toApiGet(Session session) {
		SessionApi sessionApi = null;
		if(session != null){
			sessionApi = new SessionApi();
			if (session.getAllWorker().getWorker() != null) {
				sessionApi.name = session.getAllWorker().getWorker().getName();
			} else {
				sessionApi.name = session.getAllWorker().getName();
			}
			if (session.getAllWorker().getWorker() != null) {
				sessionApi.phone = session.getAllWorker().getWorker().getPhone();
			} else {
				sessionApi.phone = null;
			}
			sessionApi.day = session.getDay();
			sessionApi.formstart = session.getFormstart();
			sessionApi.factstart = session.getFactstart();
			sessionApi.factfinish = session.getFactfinish();
			sessionApi.formfinish = session.getFormfinish();
		}
		return sessionApi;
	}
}
