package com.stasstudio.turner.workerschedule.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkerScheduleApi {
	@XmlElement(required=true)
	public Integer id;
	@XmlElement(required=true)
	public String name;	
}
