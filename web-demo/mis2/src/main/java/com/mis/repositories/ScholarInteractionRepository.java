package com.mis.repositories;

import com.mis.domain.ScholarInteraction;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarInteractionRepository extends PagingAndSortingRepository<ScholarInteraction, Integer> {


}