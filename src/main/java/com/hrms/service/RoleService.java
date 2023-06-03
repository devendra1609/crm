package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.Role;


public interface RoleService {
	public Integer insertUserType(Role role);
	public List<Role> getUserTypes();
    public Role getUserType(Integer userTypeId);
	public void updateUserType(Role role);
	public void deleteUserType(Integer userTypeId);

}
