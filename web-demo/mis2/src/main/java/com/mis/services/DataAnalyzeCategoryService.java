package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.DataAnalyzeCategory;
import com.mis.repositories.DataAnalyzeCategoryRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class DataAnalyzeCategoryService {

	@Autowired
	private DataAnalyzeCategoryRepository dataAnalyzeCategoryRepository;

	public int createDataAnalyzeCategory(DataAnalyzeCategory dataAnalyzeCategory) {
		dataAnalyzeCategoryRepository.save(dataAnalyzeCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateDataAnalyzeCategory(DataAnalyzeCategory dataAnalyzeCategory) {
		dataAnalyzeCategoryRepository.save(dataAnalyzeCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteDataAnalyzeCategory(DataAnalyzeCategory dataAnalyzeCategory) {
		dataAnalyzeCategoryRepository.delete(dataAnalyzeCategory);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public DataAnalyzeCategory findById(Integer id) {
		return dataAnalyzeCategoryRepository.findOne(id);
	}

	public List<DataAnalyzeCategory> getAll() {
		Iterator<DataAnalyzeCategory> it = dataAnalyzeCategoryRepository.findAll().iterator();
		List<DataAnalyzeCategory> list = new ArrayList<DataAnalyzeCategory>();
		for (; it.hasNext();) {
			list.add((DataAnalyzeCategory) it.next());
		}
		return list;
	}
	
	public List<DataAnalyzeCategory> getAll(Pageable pageable) {
		Iterator<DataAnalyzeCategory> it = dataAnalyzeCategoryRepository.findAll(pageable).iterator();
		List<DataAnalyzeCategory> list = new ArrayList<DataAnalyzeCategory>();
		for (; it.hasNext();) {
			list.add((DataAnalyzeCategory) it.next());
		}
		return list;
	}
	
	
}