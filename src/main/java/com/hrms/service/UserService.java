package com.hrms.service;

import java.util.List;


import com.hrms.dao.model.User;

public interface UserService {
	public User getUser(String emailId,String password);
	public Integer insertUser(User user);
	public List<User> getUsers();
	public User getUser(Integer id);
	public void updateUser(User user);
	public void deleteUser(Integer id);
	User findOne(String userName);
	
}
