package com.stasstudio.turner.news.api;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewsApi {
	@XmlElement
	public String whencreate;
	@XmlElement
	public String name;
	@XmlElement
	public String content;
	@XmlElement
	public Integer priority;
}
