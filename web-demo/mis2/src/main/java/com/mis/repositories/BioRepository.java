package com.mis.repositories;

import com.mis.domain.Bio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BioRepository extends PagingAndSortingRepository<Bio, Integer> {


}