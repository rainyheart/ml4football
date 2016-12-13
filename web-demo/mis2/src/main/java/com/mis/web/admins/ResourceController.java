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

import com.mis.domain.Resource;
import com.mis.services.ResourceService;


@Controller
@RequestMapping("/admins/resource")
public class ResourceController {

	@Autowired
    private ResourceService resourceService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<Resource> list = resourceService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody Resource resource) {
		resourceService.createResource(resource);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody Resource resource) {
		resource.setId(id);
		resourceService.updateResource(resource);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		Resource resource = resourceService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("resource", resource);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		Resource resource = resourceService.findById(id);
		resourceService.deleteResource(resource);
		return null;
	}
	
}