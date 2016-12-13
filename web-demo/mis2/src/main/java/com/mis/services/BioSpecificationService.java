package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.BioSpecification;
import com.mis.repositories.BioSpecificationRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class BioSpecificationService {

	@Autowired
	private BioSpecificationRepository bioSpecificationRepository;

	public int createBioSpecification(BioSpecification bioSpecification) {
		bioSpecificationRepository.save(bioSpecification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateBioSpecification(BioSpecification bioSpecification) {
		bioSpecificationRepository.save(bioSpecification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteBioSpecification(BioSpecification bioSpecification) {
		bioSpecificationRepository.delete(bioSpecification);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public BioSpecification findById(Integer id) {
		return bioSpecificationRepository.findOne(id);
	}
	
	public BioSpecification findByBioCategoryId(Integer id) {
		List<BioSpecification> list = bioSpecificationRepository.findByBioCategoryId(id);
		if(list != null && list.size() == 1){
			return list.get(0);
		}
		return null;
	}

	public List<BioSpecification> getAll() {
		Iterator<BioSpecification> it = bioSpecificationRepository.findAll().iterator();
		List<BioSpecification> list = new ArrayList<BioSpecification>();
		for (; it.hasNext();) {
			list.add((BioSpecification) it.next());
		}
		return list;
	}
	
	public List<BioSpecification> getAll(Pageable pageable) {
		Iterator<BioSpecification> it = bioSpecificationRepository.findAll(pageable).iterator();
		List<BioSpecification> list = new ArrayList<BioSpecification>();
		for (; it.hasNext();) {
			list.add((BioSpecification) it.next());
		}
		return list;
	}
	
	
}