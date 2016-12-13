package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.ScholarInteraction;
import com.mis.repositories.ScholarInteractionRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class ScholarInteractionService {

	@Autowired
	private ScholarInteractionRepository scholarInteractionRepository;

	public int createScholarInteraction(ScholarInteraction scholarInteraction) {
		scholarInteractionRepository.save(scholarInteraction);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateScholarInteraction(ScholarInteraction scholarInteraction) {
		scholarInteractionRepository.save(scholarInteraction);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteScholarInteraction(ScholarInteraction scholarInteraction) {
		scholarInteractionRepository.delete(scholarInteraction);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public ScholarInteraction findById(Integer id) {
		return scholarInteractionRepository.findOne(id);
	}

	public List<ScholarInteraction> getAll() {
		Iterator<ScholarInteraction> it = scholarInteractionRepository.findAll().iterator();
		List<ScholarInteraction> list = new ArrayList<ScholarInteraction>();
		for (; it.hasNext();) {
			list.add((ScholarInteraction) it.next());
		}
		return list;
	}
	
	public List<ScholarInteraction> getAll(Pageable pageable) {
		Iterator<ScholarInteraction> it = scholarInteractionRepository.findAll(pageable).iterator();
		List<ScholarInteraction> list = new ArrayList<ScholarInteraction>();
		for (; it.hasNext();) {
			list.add((ScholarInteraction) it.next());
		}
		return list;
	}
	
	
}