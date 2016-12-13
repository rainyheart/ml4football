package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.DataAnalyze;
import com.mis.repositories.DataAnalyzeRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class DataAnalyzeService {

	@Autowired
	private DataAnalyzeRepository dataAnalyzeRepository;

	public int createDataAnalyze(DataAnalyze dataAnalyze) {
		dataAnalyzeRepository.save(dataAnalyze);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateDataAnalyze(DataAnalyze dataAnalyze) {
		dataAnalyzeRepository.save(dataAnalyze);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteDataAnalyze(DataAnalyze dataAnalyze) {
		dataAnalyzeRepository.delete(dataAnalyze);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public DataAnalyze findById(Integer id) {
		return dataAnalyzeRepository.findOne(id);
	}

	public List<DataAnalyze> getAll() {
		Iterator<DataAnalyze> it = dataAnalyzeRepository.findAll().iterator();
		List<DataAnalyze> list = new ArrayList<DataAnalyze>();
		for (; it.hasNext();) {
			list.add((DataAnalyze) it.next());
		}
		return list;
	}
	
	public List<DataAnalyze> getAll(Pageable pageable) {
		Iterator<DataAnalyze> it = dataAnalyzeRepository.findAll(pageable).iterator();
		List<DataAnalyze> list = new ArrayList<DataAnalyze>();
		for (; it.hasNext();) {
			list.add((DataAnalyze) it.next());
		}
		return list;
	}
	
	
}