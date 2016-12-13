package com.mis.web.admins;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domain.User;
import com.mis.services.UserService;


@Controller
@RequestMapping("/admins/user")
public class UserController {

	@Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<User> list = userService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody User user) {
		userService.createUser(user);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@RequestBody User user) {
		userService.updateUser(user);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		User user = userService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("user", user);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		User user = userService.findById(id);
		userService.deleteUser(user);
		return null;
	}
	
	@RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getTeamMembers(@PathVariable("id")Integer id) {
		List<User> list = userService.getTeamMembers(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
}