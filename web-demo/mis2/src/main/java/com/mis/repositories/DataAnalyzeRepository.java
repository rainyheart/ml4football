package com.mis.repositories;

import com.mis.domain.DataAnalyze;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalyzeRepository extends PagingAndSortingRepository<DataAnalyze, Integer> {


}