package com.mis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);
	
	@Query(value="select * from user u where u.team_id=:teamId",nativeQuery=true)
    List<User> findUsersByTeamId(@Param("teamId") int teamId);
}