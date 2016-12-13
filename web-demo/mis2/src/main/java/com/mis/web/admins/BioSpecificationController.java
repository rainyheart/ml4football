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

import com.mis.domain.BioSpecification;
import com.mis.services.BioSpecificationService;


@Controller
@RequestMapping("/admins/bioSpecification")
public class BioSpecificationController {

	@Autowired
    private BioSpecificationService bioSpecificationService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<BioSpecification> list = bioSpecificationService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody BioSpecification bioSpecification) {
		bioSpecificationService.createBioSpecification(bioSpecification);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody BioSpecification bioSpecification) {
		bioSpecification.setId(id);
		bioSpecificationService.updateBioSpecification(bioSpecification);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		BioSpecification bioSpecification = bioSpecificationService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("bioSpecification", bioSpecification);
		return model;
	}
	
	@RequestMapping(value = "bioCategory/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getByBioId(@PathVariable("id")Integer id) {
		BioSpecification bioSpecification = bioSpecificationService.findByBioCategoryId(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("bioSpecification", bioSpecification);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		BioSpecification bioSpecification = bioSpecificationService.findById(id);
		bioSpecificationService.deleteBioSpecification(bioSpecification);
		return null;
	}
	
}