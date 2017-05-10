package com.stasstudio.turner.mappers;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import com.stasstudio.turner.domain.New;
import com.stasstudio.turner.news.api.NewsApi;

@Component
public class NewsMapper {
	public NewsApi toApiGet(New news) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		NewsApi newsApi = null;	
		if(news != null){
			newsApi = new NewsApi();
			newsApi.whencreate = simpleDateFormat.format(news.getWhencreate());	
			if(news.getAllWorker().getWorker() != null){
			newsApi.name = news.getAllWorker().getWorker().getName();
			} else{
				newsApi.name = news.getAllWorker().getName();
			}
			newsApi.content = news.getContent();
			newsApi.priority = news.getPriority();
		}
		return newsApi;
	}
}
