package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mis.domain.User;
import com.mis.repositories.UserRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public int createUser(User user) {
		userRepository.save(user);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateUser(User user) {
		userRepository.save(user);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteUser(User user) {
		userRepository.delete(user);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public User findById(Integer id) {
		return userRepository.findOne(id);
	}
	
	public User findByUsername(String username){
		return userRepository.findUser(username);
	}

	public List<User> getAll() {
		Iterator<User> it = userRepository.findAll().iterator();
		List<User> list = new ArrayList<User>();
		for (; it.hasNext();) {
			list.add((User) it.next());
		}
		return list;
	}
	
	public List<User> getTeamMembers(int teamId) {
		return userRepository.findUsersByTeamId(teamId);
	}
	
	
}