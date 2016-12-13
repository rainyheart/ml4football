package com.mis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.BioCategory;

@Repository
public interface BioCategoryRepository extends PagingAndSortingRepository<BioCategory, Integer> {
	
	@Query("from BioCategory b where b.bioParentId is null or b.bioParentId = 0")
    List<BioCategory> findAllParents();
	
	@Query("from BioCategory b where b.bioParentId = :bioParentId")
	List<BioCategory> findChildrenByParentId(@Param("bioParentId") Integer bioParentId);
	
	@Query("from BioCategory b where b.id != :id and (b.bioParentId is null or b.bioParentId = 0)")
    List<BioCategory> findAvailableParents(@Param("id")Integer id);
	
	@Query("from BioCategory b where b.bioParentId > 0")
    List<BioCategory> findAllChildren();


}