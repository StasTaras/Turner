package com.stasstudio.turner.schedule.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.stasstudio.turner.general.api.GenericReply;

@XmlRootElement
public class ScheduleApiListReply extends GenericReply{
	@XmlElement
	public List<ScheduleApi> scheduleApi = new ArrayList<ScheduleApi>();
}
