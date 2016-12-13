package com.mis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.BioSpecification;

@Repository
public interface BioSpecificationRepository extends PagingAndSortingRepository<BioSpecification, Integer> {
	
	@Query("from BioSpecification b where b.bioCategory.id =:bioCategoryId")
	List<BioSpecification> findByBioCategoryId(@Param("bioCategoryId") Integer bioCategoryId);


}