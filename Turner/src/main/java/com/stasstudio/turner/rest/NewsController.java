package com.stasstudio.turner.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stasstudio.turner.mappers.NewsMapper;
import com.stasstudio.turner.news.api.NewsApiListReply;
import com.stasstudio.turner.services.NewsService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class NewsController {
	
	@Autowired
	NewsMapper newsMapper;
	@Autowired
	NewsService newsService;
	
	@RequestMapping(path = "/news", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public NewsApiListReply getAllnews() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date daysAgo = new DateUtils().addDays(new Date(),-30);
		String date_local = simpleDateFormat.format(daysAgo);
		System.out.println(date_local);
		Date startDate = null;
		LocalDateTime ldt = null;
		try {
			startDate = simpleDateFormat.parse(date_local);
			ldt = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		NewsApiListReply newsApiListReply = new NewsApiListReply();
		LocalDateTime finalLdt = ldt;
		newsApiListReply.newsApi.addAll(newsService.getAll()
				.stream()
				.filter(cur_date -> cur_date.getWhencreate().toLocalDateTime().isAfter(finalLdt))
				.map(news -> newsMapper.toApiGet(news))
				.collect(Collectors.toList()));
		return newsApiListReply;
	}

	@RequestMapping(path = "/news/{countLastDay}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public NewsApiListReply getAllnews(HttpServletResponse response,
									   @PathVariable int countLastDay) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date daysAgo = new DateUtils().addDays(new Date(),-countLastDay);
		String date_local = simpleDateFormat.format(daysAgo);
		System.out.println(date_local);
		Date startDate = null;
		LocalDateTime ldt = null;
		try {
			startDate = simpleDateFormat.parse(date_local);
			ldt = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		NewsApiListReply newsApiListReply = new NewsApiListReply();
		LocalDateTime finalLdt = ldt;
		newsApiListReply.newsApi.addAll(newsService.getAll()
				.stream()
				.filter(cur_date -> cur_date.getWhencreate().toLocalDateTime().isAfter(finalLdt))
				.map(news -> newsMapper.toApiGet(news))
				.collect(Collectors.toList()));
		return newsApiListReply;
	}

}
