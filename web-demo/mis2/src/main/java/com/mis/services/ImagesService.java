package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Images;
import com.mis.repositories.ImagesRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class ImagesService {

	@Autowired
	private ImagesRepository imagesRepository;

	public int createImages(Images images) {
		imagesRepository.save(images);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateImages(Images images) {
		imagesRepository.save(images);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteImages(Images images) {
		imagesRepository.delete(images);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Images findById(Integer id) {
		return imagesRepository.findOne(id);
	}

	public List<Images> getAll() {
		Iterator<Images> it = imagesRepository.findAll().iterator();
		List<Images> list = new ArrayList<Images>();
		for (; it.hasNext();) {
			list.add((Images) it.next());
		}
		return list;
	}
	
	public List<Images> getAll(Pageable pageable) {
		Iterator<Images> it = imagesRepository.findAll(pageable).iterator();
		List<Images> list = new ArrayList<Images>();
		for (; it.hasNext();) {
			list.add((Images) it.next());
		}
		return list;
	}
	
	
}