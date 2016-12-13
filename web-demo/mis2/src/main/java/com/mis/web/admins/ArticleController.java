package com.mis.web.admins;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domain.Article;
import com.mis.domain.User;
import com.mis.services.ArticleService;
import com.mis.util.Constants;


@Controller
@RequestMapping("/admins/article")
public class ArticleController {

	@Autowired
    private ArticleService articleService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<Article> list = articleService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody Article article, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		User sessionUser = (User)httpSession.getAttribute(Constants.SESSION_USER);
		article.setCreateBy(sessionUser);
		
		articleService.createArticle(article);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@RequestBody Article article) {
		articleService.updateArticle(article);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		Article article = articleService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("article", article);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		Article article = articleService.findById(id);
		articleService.deleteArticle(article);
		return null;
	}
	
}