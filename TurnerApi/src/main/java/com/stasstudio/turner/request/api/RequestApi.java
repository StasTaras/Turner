package com.stasstudio.turner.request.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestApi {
	@XmlElement(required=true)
	public String whencreate;
	@XmlElement(required=true)
	public String author_name;
	@XmlElement(required=true)
	public String content;
	@XmlElement(required=true)
	public boolean isdone;
	@XmlElement(required=true)
	public Integer priority;
	@XmlElement(required=true)
	public String whendone;

}
