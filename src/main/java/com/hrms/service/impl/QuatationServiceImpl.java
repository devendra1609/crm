package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.QuatationDAO;
import com.hrms.dao.model.Quatation;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.QuatationService;

@Service
public class QuatationServiceImpl implements QuatationService{
	@Autowired
	private QuatationDAO quatationDAO;

	@Override
	public Integer insertQuatation(Quatation quatation) {
		try {
			Quatation quat=quatationDAO.save(quatation);
			if(quat!=null) {
				return quat.getProductId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<Quatation> getQuatations() {
		try {
			return quatationDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public Quatation getQuatation(Integer quatationId) {
		try {
			return quatationDAO.findById(quatationId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateQuatation(Quatation quatation) {
		try {
			if(quatation!=null) {
				quatationDAO.save(quatation);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteQuatation(Integer quatationId) {
		try {
			quatationDAO.deleteById(quatationId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}
}
