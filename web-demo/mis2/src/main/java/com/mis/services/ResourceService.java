package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Resource;
import com.mis.repositories.ResourceRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class ResourceService {

	@Autowired
	private ResourceRepository resourceRepository;

	public int createResource(Resource resource) {
		resourceRepository.save(resource);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateResource(Resource resource) {
		resourceRepository.save(resource);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteResource(Resource resource) {
		resourceRepository.delete(resource);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Resource findById(Integer id) {
		return resourceRepository.findOne(id);
	}

	public List<Resource> getAll() {
		Iterator<Resource> it = resourceRepository.findAll().iterator();
		List<Resource> list = new ArrayList<Resource>();
		for (; it.hasNext();) {
			list.add((Resource) it.next());
		}
		return list;
	}
	
	public List<Resource> getAll(Pageable pageable) {
		Iterator<Resource> it = resourceRepository.findAll(pageable).iterator();
		List<Resource> list = new ArrayList<Resource>();
		for (; it.hasNext();) {
			list.add((Resource) it.next());
		}
		return list;
	}
	
	
}