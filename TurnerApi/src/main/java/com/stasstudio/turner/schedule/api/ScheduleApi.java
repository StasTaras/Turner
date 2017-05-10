package com.stasstudio.turner.schedule.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleApi {
	@XmlElement
	public String workplaceName;
	@XmlElement
	public String workersName;
	@XmlElement
	public String startDate;
	@XmlElement
	public String startTime;
	@XmlElement
	public String finishTime;	
}
