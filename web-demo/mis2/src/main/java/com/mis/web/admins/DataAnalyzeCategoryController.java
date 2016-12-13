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

import com.mis.domain.DataAnalyzeCategory;
import com.mis.services.DataAnalyzeCategoryService;


@Controller
@RequestMapping("/admins/dataAnalyzeCategory")
public class DataAnalyzeCategoryController {

	@Autowired
    private DataAnalyzeCategoryService dataAnalyzeCategoryService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<DataAnalyzeCategory> list = dataAnalyzeCategoryService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody DataAnalyzeCategory dataAnalyzeCategory) {
		dataAnalyzeCategoryService.createDataAnalyzeCategory(dataAnalyzeCategory);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody DataAnalyzeCategory dataAnalyzeCategory) {
		dataAnalyzeCategory.setId(id);
		dataAnalyzeCategoryService.updateDataAnalyzeCategory(dataAnalyzeCategory);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		DataAnalyzeCategory dataAnalyzeCategory = dataAnalyzeCategoryService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("dataAnalyzeCategory", dataAnalyzeCategory);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		DataAnalyzeCategory dataAnalyzeCategory = dataAnalyzeCategoryService.findById(id);
		dataAnalyzeCategoryService.deleteDataAnalyzeCategory(dataAnalyzeCategory);
		return null;
	}
	
}