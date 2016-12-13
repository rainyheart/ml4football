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

import com.mis.domain.Bio;
import com.mis.services.BioService;


@Controller
@RequestMapping("/admins/bio")
public class BioController {

	@Autowired
    private BioService bioService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<Bio> list = bioService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody Bio bio) {
		bioService.createBio(bio);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody Bio bio) {
		bio.setId(id);
		bioService.updateBio(bio);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		Bio bio = bioService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("bio", bio);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		Bio bio = bioService.findById(id);
		bioService.deleteBio(bio);
		return null;
	}
	
}