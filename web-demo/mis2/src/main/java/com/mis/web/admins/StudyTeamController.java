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

import com.mis.domain.StudyTeam;
import com.mis.domain.StudyTeamVo;
import com.mis.domain.User;
import com.mis.services.StudyTeamService;
import com.mis.services.UserService;


@Controller
@RequestMapping("/admins/studyTeam")
public class StudyTeamController {

	@Autowired
    private StudyTeamService studyTeamService;
	
	@Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAll() {
		List<StudyTeam> list = studyTeamService.getAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", list);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> create(@RequestBody StudyTeam studyTeam) {
		studyTeamService.createStudyTeam(studyTeam);
		return null;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,Object> update(@RequestBody StudyTeam studyTeam) {
		studyTeamService.updateStudyTeam(studyTeam);
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> get(@PathVariable("id")Integer id) {
		StudyTeam studyTeam = studyTeamService.findById(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("studyTeam", studyTeam);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delete(@PathVariable("id")Integer id) {
		StudyTeam studyTeam = studyTeamService.findById(id);
		studyTeamService.deleteStudyTeam(studyTeam);
		return null;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getMainTeam() {
		StudyTeam studyTeam = studyTeamService.getMainTeam();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("studyTeam", studyTeam);
		return model;
	}
	
	@RequestMapping(value = "/other", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getOtherTeam() {
		List<StudyTeam> list = studyTeamService.getOtherTeam();
		List<StudyTeamVo> result = new ArrayList<StudyTeamVo>();
		for(StudyTeam studyTeam:list){
			StudyTeamVo vo = new StudyTeamVo();
			List<User> users = userService.getTeamMembers(studyTeam.getId());
			BeanUtils.copyProperties(studyTeam, vo);
			vo.setUsers(users);
			result.add(vo);
		}
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("list", result);
		return model;
	}
	
}