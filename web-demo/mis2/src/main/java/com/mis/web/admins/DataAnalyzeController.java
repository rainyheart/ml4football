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

import com.mis.domain.DataAnalyze;
import com.mis.services.DataAnalyzeService;


@Controller
@RequestMapping("/admins/dataAnalyze")
public class DataAnalyzeController {

	@Autowired
    private DataAnalyzeService dataAnalyzeService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<DataAnalyze> list = dataAnalyzeService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody DataAnalyze dataAnalyze) {
		dataAnalyzeService.createDataAnalyze(dataAnalyze);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody DataAnalyze dataAnalyze) {
		dataAnalyze.setId(id);
		dataAnalyzeService.updateDataAnalyze(dataAnalyze);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		DataAnalyze dataAnalyze = dataAnalyzeService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("dataAnalyze", dataAnalyze);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		DataAnalyze dataAnalyze = dataAnalyzeService.findById(id);
		dataAnalyzeService.deleteDataAnalyze(dataAnalyze);
		return null;
	}
	
}