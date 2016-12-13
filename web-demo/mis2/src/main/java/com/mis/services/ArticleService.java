package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Article;
import com.mis.repositories.ArticleRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public int createArticle(Article article) {
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		articleRepository.save(article);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateArticle(Article article) {
		articleRepository.updateArticle(article.getId(), article.getSubject(), article.getContent());
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteArticle(Article article) {
		articleRepository.delete(article);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Article findById(Integer id) {
		return articleRepository.findOne(id);
	}

	public List<Article> getAll() {
		Iterator<Article> it = articleRepository.findAll().iterator();
		List<Article> list = new ArrayList<Article>();
		for (; it.hasNext();) {
			list.add((Article) it.next());
		}
		return list;
	}
	
	public List<Article> getAll(Pageable pageable) {
		Iterator<Article> it = articleRepository.findAll(pageable).iterator();
		List<Article> list = new ArrayList<Article>();
		for (; it.hasNext();) {
			list.add((Article) it.next());
		}
		return list;
	}
	
	
}