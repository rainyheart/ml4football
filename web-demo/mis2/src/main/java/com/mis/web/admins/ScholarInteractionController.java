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

import com.mis.domain.ScholarInteraction;
import com.mis.services.ScholarInteractionService;


@Controller
@RequestMapping("/admins/scholarInteraction")
public class ScholarInteractionController {

	@Autowired
    private ScholarInteractionService scholarInteractionService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<ScholarInteraction> list = scholarInteractionService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody ScholarInteraction scholarInteraction) {
		scholarInteractionService.createScholarInteraction(scholarInteraction);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody ScholarInteraction scholarInteraction) {
		scholarInteraction.setId(id);
		scholarInteractionService.updateScholarInteraction(scholarInteraction);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		ScholarInteraction scholarInteraction = scholarInteractionService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("scholarInteraction", scholarInteraction);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		ScholarInteraction scholarInteraction = scholarInteractionService.findById(id);
		scholarInteractionService.deleteScholarInteraction(scholarInteraction);
		return null;
	}
	
}