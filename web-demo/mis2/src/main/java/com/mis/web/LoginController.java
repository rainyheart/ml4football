package com.mis.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mis.domain.News;
import com.mis.domain.User;
import com.mis.services.UserService;
import com.mis.util.Constants;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(@RequestBody User user, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Map<String,Object> model = new HashMap<String,Object>();
		User dbUser = userService.findByUsername(user.getUsername());
		if(dbUser != null && dbUser.getPassword().equals(user.getPassword())){
			model.put("status", "1");
			httpSession.setAttribute(Constants.SESSION_USER, dbUser);
			System.out.println("login successful! username:" + user.getUsername() + ",pwd:" + user.getPassword());
		}else{
			model.put("status", "-1");
		}
		return model;
	}
	
	@RequestMapping(value="/logoutasdf", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> logout(@RequestBody User user, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Map<String,Object> model = new HashMap<String,Object>();
		User dbUser = userService.findByUsername(user.getUsername());
		if(dbUser != null && dbUser.getPassword().equals(user.getPassword())){
			model.put("status", "1");
			httpSession.removeAttribute("loginUser" + String.valueOf(dbUser.getId()));
		}else{
			model.put("status", "-1");
		}
		return model;
	}
	
	
	@RequestMapping(value="/logiasdfn/list")
	public Map<String,Object> getNews() {
		Map<String,Object> model = new HashMap<String,Object>();
		return model;
	}

	@RequestMapping(value = "/logisdfn/{id}", method = RequestMethod.PUT)
	public Map<String,Object> updateNews(@PathVariable("id")int id,@RequestBody News newsEntity) {
		newsEntity.setId(id);
		return null;
	}
	
	@RequestMapping(value = "/logisdfn/{id}", method = RequestMethod.DELETE)
	public Map<String,Object> deleteNews(@PathVariable("id")Long id) {
		return null;
	}

}
