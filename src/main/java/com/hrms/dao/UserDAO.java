package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	public User findByEmailIdAndPassword(String emailId,String password);
	User findByUserName(String userName);
}
