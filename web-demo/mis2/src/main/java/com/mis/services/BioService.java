package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Bio;
import com.mis.repositories.BioRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class BioService {

	@Autowired
	private BioRepository bioRepository;

	public int createBio(Bio bio) {
		bioRepository.save(bio);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateBio(Bio bio) {
		bioRepository.save(bio);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteBio(Bio bio) {
		bioRepository.delete(bio);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Bio findById(Integer id) {
		return bioRepository.findOne(id);
	}

	public List<Bio> getAll() {
		Iterator<Bio> it = bioRepository.findAll().iterator();
		List<Bio> list = new ArrayList<Bio>();
		for (; it.hasNext();) {
			list.add((Bio) it.next());
		}
		return list;
	}
	
	public List<Bio> getAll(Pageable pageable) {
		Iterator<Bio> it = bioRepository.findAll(pageable).iterator();
		List<Bio> list = new ArrayList<Bio>();
		for (; it.hasNext();) {
			list.add((Bio) it.next());
		}
		return list;
	}
	
	
}