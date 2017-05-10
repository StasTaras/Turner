package com.stasstudio.turner.request.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.stasstudio.turner.general.api.GenericReply;

@XmlRootElement
public class RequestApiListReply extends GenericReply{
	@XmlElement(required=true)
    public List <RequestApi> requestApi = new ArrayList<RequestApi>();
}
