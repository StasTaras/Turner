package com.stasstudio.turner.session.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.stasstudio.turner.general.api.GenericReply;

@XmlRootElement
public class SessionApiListReply extends GenericReply{
	@XmlElement(required=true)
	public List<SessionApi> sessionApi = new ArrayList<SessionApi>();
}
