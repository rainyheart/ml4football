package com.mis.repositories;

import com.mis.domain.Images;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends PagingAndSortingRepository<Images, Integer> {


}