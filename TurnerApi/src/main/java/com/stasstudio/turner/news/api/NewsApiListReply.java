package com.stasstudio.turner.news.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.stasstudio.turner.general.api.GenericReply;

@XmlRootElement
public class NewsApiListReply extends GenericReply {
	@XmlElement
	public List<NewsApi> newsApi = new ArrayList<NewsApi>();
}
