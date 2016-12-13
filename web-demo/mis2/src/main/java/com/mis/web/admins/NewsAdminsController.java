package com.mis.web.admins;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.ActionContext;
import com.mis.domain.News;
import com.mis.domain.User;
import com.mis.services.NewsService;


@Controller
@RequestMapping("/admins/news")
public class NewsAdminsController {

	@Autowired
    private NewsService newsService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<News> list = newsService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody News news, HttpSession httpSession) {
		User user = ActionContext.getSessionUser(httpSession);
		news.setCreateBy(user);
		newsService.createNews(news);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")int id,@RequestBody News news, HttpSession httpSession) {
		news.setId(id);
//		User user = ActionContext.getSessionUser(httpSession);
		newsService.updateNews(news);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")int id) {
		News news = newsService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("news", news);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		News news = newsService.findById(id);
		newsService.deleteNews(news);
		return null;
	}
	
}