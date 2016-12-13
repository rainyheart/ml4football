package com.mis.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.StudyTeam;
import com.mis.domain.StudyTeamVo;
import com.mis.repositories.StudyTeamRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class StudyTeamService {

	@Autowired
	private StudyTeamRepository studyTeamRepository;

	public int createStudyTeam(StudyTeam studyTeam) {
		studyTeamRepository.save(studyTeam);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateStudyTeam(StudyTeam studyTeam) {
		studyTeamRepository.save(studyTeam);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteStudyTeam(StudyTeam studyTeam) {
		studyTeamRepository.delete(studyTeam);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public StudyTeam findById(Integer id) {
		return studyTeamRepository.findOne(id);
	}

	public List<StudyTeam> getAll() {
		Iterator<StudyTeam> it = studyTeamRepository.findAll().iterator();
		List<StudyTeam> list = new ArrayList<StudyTeam>();
		for (; it.hasNext();) {
			list.add((StudyTeam) it.next());
		}
		return list;
	}
	
	public List<StudyTeam> getAll(Pageable pageable) {
		Iterator<StudyTeam> it = studyTeamRepository.findAll(pageable).iterator();
		List<StudyTeam> list = new ArrayList<StudyTeam>();
		for (; it.hasNext();) {
			list.add((StudyTeam) it.next());
		}
		return list;
	}
	
	public StudyTeam getMainTeam() {
		List<StudyTeam> list = studyTeamRepository.findTeamByType(1);
		if(list != null){
			return list.get(0);
		}
		return null;
	}
	
	public List<StudyTeam> getOtherTeam() {
		return studyTeamRepository.findTeamByType(2);
	}
	
	
}