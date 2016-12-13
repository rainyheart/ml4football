package com.mis.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.News;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Integer> {


	@Modifying
	@Query("update News t set t.subject=:subject, t.content=:content, t.updateDate=:updateDate where t.id=:id")
	void updateNews(@Param("id") Integer id, @Param("subject") String subject, @Param("content") String content, @Param("updateDate") Date updateDate);
	
	


}