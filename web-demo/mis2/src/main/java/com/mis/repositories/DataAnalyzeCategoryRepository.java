package com.mis.repositories;

import com.mis.domain.DataAnalyzeCategory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalyzeCategoryRepository extends PagingAndSortingRepository<DataAnalyzeCategory, Integer> {


}