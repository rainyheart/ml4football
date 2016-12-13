package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.BioCategory;
import com.mis.repositories.BioCategoryRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class BioCategoryService {

	@Autowired
	private BioCategoryRepository bioCategoryRepository;

	public int createBioCategory(BioCategory bioCategory) {
		bioCategoryRepository.save(bioCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateBioCategory(BioCategory bioCategory) {
		bioCategoryRepository.save(bioCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteBioCategory(BioCategory bioCategory) {
		bioCategoryRepository.delete(bioCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public BioCategory findById(Integer id) {
		return bioCategoryRepository.findOne(id);
	}

	public List<BioCategory> getAll() {
		Iterator<BioCategory> it = bioCategoryRepository.findAll().iterator();
		List<BioCategory> list = new ArrayList<BioCategory>();
		for (; it.hasNext();) {
			list.add((BioCategory) it.next());
		}
		return list;
	}
	
	public List<BioCategory> getAll(Pageable pageable) {
		Iterator<BioCategory> it = bioCategoryRepository.findAll(pageable).iterator();
		List<BioCategory> list = new ArrayList<BioCategory>();
		for (; it.hasNext();) {
			list.add((BioCategory) it.next());
		}
		return list;
	}
	
	public List<BioCategory> getParentList() {
		return bioCategoryRepository.findAllParents();
	}
	
	public List<BioCategory> getAllChildren() {
		return bioCategoryRepository.findAllChildren();
	}
	
	public List<BioCategory> findChildrenByParentId(Integer bioParentId) {
		return bioCategoryRepository.findChildrenByParentId(bioParentId);
	}
	
	
	public List<BioCategory> getAvailableParents(Integer id) {
		return bioCategoryRepository.findAvailableParents(id);
	}
	
	
	
}