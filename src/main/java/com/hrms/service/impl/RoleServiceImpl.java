package com.hrms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.RoleDAO;
import com.hrms.dao.model.Role;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.RoleService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	@Override
	public Integer insertUserType(Role role) {
		try {
			log.info("{}-ServiceImpl insertUserType() saving UserType");
			Role product=roleDAO.save(role);
			if(product!=null) {
				return product.getUserTypeId();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error("{}-ServiceImpl-insertUserType()-exception occured-{}");
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<Role> getUserTypes() {
		log.info("{}-ServiceImpl getUserType() Started");
		try {
			log.info("{}-ServiceImpl getUserType() getting Product");
			return roleDAO.findAll();
		} catch (Exception e) {
			log.error("{}-ServiceImpl-getUserType()-exception occured-{}",e.getMessage());
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public Role getUserType(Integer userTypeId) {
		log.info("{}-ServiceImpl getProduct() Started");
		try {
			log.info("{}-ServiceImpl getUserType() saving Product");
			return roleDAO.findById(userTypeId).get();
		} catch (Exception e) {
			log.error("{}-ServiceImpl-getUserType()-exception occured-{}",e.getMessage());
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateUserType(Role role) {
		log.info("{}-ServiceImpl updateUserType() Started");
		try {
			log.info("{}-ServiceImpl updateUserType()");
			roleDAO.save(role);
		} catch (Exception e) {
			log.error("{}-ServiceImpl-updateUserType()-exception occured-{}",e.getMessage());
			throw new EmployeeCustomException(e.getMessage());
		}		
	}

	@Override
	public void deleteUserType(Integer userTypeId) {
		log.info("{}-ServiceImpl deleteProduct() Started");
		try {
			log.info("{}-ServiceImpl deleteUserType() ");
			roleDAO.deleteById(userTypeId);
		} catch (Exception e) {
			log.error("{}-ServiceImpl-deleteUserType()-exception occured-{}",e.getMessage());
			throw new EmployeeCustomException(e.getMessage());
		}		
	}

    

}
