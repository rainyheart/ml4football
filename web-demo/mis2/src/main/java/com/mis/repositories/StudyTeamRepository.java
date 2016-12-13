package com.mis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.StudyTeam;
import com.mis.domain.StudyTeamVo;

@Repository
public interface StudyTeamRepository extends PagingAndSortingRepository<StudyTeam, Integer> {

	/**
	 * 
	 * @Query("from StudyTeamVo s, User u where u.teamId = s.id and
	 * s.type=:type") List<StudyTeamVo> findTeamByType(@Param("type") int type);
	 * 
	 * @param type
	 * @return
	 */

	@Query("from StudyTeam s where s.type=:type")
	List<StudyTeam> findTeamByType(@Param("type") int type);
}