package com.hrms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrms.dao.UserDAO;
import com.hrms.dao.model.User;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserDetailsService,UserService{
		@Autowired
		private UserDAO userDAO;
		
		
		 public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		        User user = userDAO.findByUserName(userName);
		        if(user == null){
		            throw new UsernameNotFoundException("Invalid username or password.");
		        }
		        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
		    }
		 private Set<SimpleGrantedAuthority> getAuthority(User user) {
		        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		        user.getRoles().forEach(role -> {
		            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getUserType()));
		        });
		        return authorities;
		    }
		
		@Override
		public User getUser(String emailId, String password) {
			try {
				return userDAO.findByEmailIdAndPassword(emailId, password);
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
		}

		@Override
		public Integer insertUser(User user) {
			try {
				User user1=userDAO.save(user);
				if(user1!=null) {
					return (int) user1.getId();
				}
				else {
					return null;
				}
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
		}

		@Override
		public List<User> getUsers() {
			try {
				return userDAO.findAll();
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
		}

		@Override
		public User getUser(Integer id) {
			try {
				return userDAO.findById(id).get();
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
		}

		@Override
		public void updateUser(User user) {
			try {
				userDAO.save(user);
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
			
		}

		@Override
		public void deleteUser(Integer id) {
			try {
				userDAO.deleteById(id);
			} catch (Exception e) {
				throw new EmployeeCustomException(e.getMessage());
			}
			
		}

		@Override
		public User findOne(String userName) {
			
			return userDAO.findByUserName(userName);
		}
		

}
