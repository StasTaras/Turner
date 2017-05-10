package com.stasstudio.turner.workerschedule.api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.stasstudio.turner.general.api.GenericReply;

@XmlRootElement
public class WorkerScheduleApiListReply extends GenericReply{
	@XmlElement
	public List<WorkerScheduleApi> workerSchedule = new ArrayList<WorkerScheduleApi>();
}
