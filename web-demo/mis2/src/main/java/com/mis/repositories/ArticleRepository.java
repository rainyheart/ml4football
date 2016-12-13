package com.mis.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.Article;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {
	
	@Modifying
	@Query(value = "update article t set t.subject=:mySubject, t.content=:myContent where t.id =:myId",nativeQuery=true)
	public void updateArticle(@Param("myId") Integer myId, @Param("mySubject") String mySubject, @Param("myContent") String myContent);


}