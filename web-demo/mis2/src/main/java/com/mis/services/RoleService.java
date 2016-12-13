package com.mis.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.mis.domain.Role;
import com.mis.repositories.RoleRepository;
import com.mis.util.Constants;

@Component
@Transactional
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public int createRole(Role role) {
		roleRepository.save(role);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int updateRole(Role role) {
		roleRepository.save(role);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public int deleteRole(Role role) {
		roleRepository.delete(role);
		return Constants.RETURN_STATUS_SUCCESS;
	}

	public Role findById(Integer id) {
		return roleRepository.findOne(id);
	}

	public List<Role> getAll() {
		Iterator<Role> it = roleRepository.findAll().iterator();
		List<Role> list = new ArrayList<Role>();
		for (; it.hasNext();) {
			list.add((Role) it.next());
		}
		return list;
	}
	
	public List<Role> getAll(Pageable pageable) {
		Iterator<Role> it = roleRepository.findAll(pageable).iterator();
		List<Role> list = new ArrayList<Role>();
		for (; it.hasNext();) {
			list.add((Role) it.next());
		}
		return list;
	}
	
	
}