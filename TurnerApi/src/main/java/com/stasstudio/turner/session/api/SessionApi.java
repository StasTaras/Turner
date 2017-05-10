package com.stasstudio.turner.session.api;

import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SessionApi {	
	@XmlElement
	public String name;
	@XmlElement
	public String phone;
	@XmlElement
	public Date day;
	@XmlElement
	public Time formstart;
	@XmlElement
	public Time factstart;
	@XmlElement
	public Time factfinish;
	@XmlElement
	public Time formfinish;
}
