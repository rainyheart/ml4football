package com.mis.web.admins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domain.BioCategory;
import com.mis.domain.BioCategoryVo;
import com.mis.services.BioCategoryService;


@Controller
@RequestMapping("/admins/bioCategory")
public class BioCategoryController {

	@Autowired
    private BioCategoryService bioCategoryService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<BioCategory> list = bioCategoryService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody BioCategory bioCategory) {
		bioCategoryService.createBioCategory(bioCategory);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@PathVariable("id")Integer id,@RequestBody BioCategory bioCategory) {
		bioCategory.setId(id);
		bioCategoryService.updateBioCategory(bioCategory);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		BioCategory bioCategory = bioCategoryService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("bioCategory", bioCategory);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		BioCategory bioCategory = bioCategoryService.findById(id);
		bioCategoryService.deleteBioCategory(bioCategory);
		return null;
	}
	
	@RequestMapping(value = "/parents", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getParents() {
		List<BioCategory> parentList = bioCategoryService.getParentList();
		List<BioCategoryVo> result = new ArrayList<BioCategoryVo>();
		
		for(BioCategory bioCategory:parentList){
			List<BioCategory> children = bioCategoryService.findChildrenByParentId(bioCategory.getId());
			BioCategoryVo bioCategoryVo = new BioCategoryVo();
			BeanUtils.copyProperties(bioCategory, bioCategoryVo);
			bioCategoryVo.setBioCategoryList(children);
			result.add(bioCategoryVo);
		}
		
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", result);
		return model;
	}
	
	@RequestMapping(value = "/children", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getChildren() {
		List<BioCategory> children = bioCategoryService.getAllChildren();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", children);
		return model;
	}
	
	@RequestMapping(value = "/parents/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAvailableParents(@PathVariable("id")Integer id) {
		List<BioCategory> parentList = bioCategoryService.getAvailableParents(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", parentList);
		return model;
	}
	
	@RequestMapping(value = "/children/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getChildrenByPraentId(@PathVariable("id")Integer bioParentId) {
		List<BioCategory> children = bioCategoryService.findChildrenByParentId(bioParentId);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", children);
		return model;
	}
	
	
	
	
	
}