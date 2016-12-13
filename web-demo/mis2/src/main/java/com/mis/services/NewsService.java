package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.News;
import com.mis.repositories.NewsRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;

	public int createNews(News news) {
		news.setCreateDate(new Date());
		news.setUpdateDate(new Date());
		newsRepository.save(news);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateNews(News news) {
		news.setUpdateDate(new Date());
		newsRepository.updateNews(news.getId(),news.getSubject(), news.getContent(), news.getUpdateDate());
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteNews(News news) {
		newsRepository.delete(news);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public News findById(Integer id) {
		return newsRepository.findOne(id);
	}

	public List<News> getAll() {
		Iterator<News> it = newsRepository.findAll().iterator();
		List<News> list = new ArrayList<News>();
		for (; it.hasNext();) {
			list.add((News) it.next());
		}
		return list;
	}
	
	public List<News> getAll(Pageable pageable) {
		Iterator<News> it = newsRepository.findAll(pageable).iterator();
		List<News> list = new ArrayList<News>();
		for (; it.hasNext();) {
			list.add((News) it.next());
		}
		return list;
	}
	
	
	
	
}