package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.LeaveTypeDAO;
import com.hrms.dao.model.LeaveType;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.LeaveTypeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaveTypeServiceImpl implements LeaveTypeService{
	@Autowired
	private LeaveTypeDAO leaveTypeDAO;

	@Override
	public Integer insertLeaveType(LeaveType leaveType) {
		log.info("{}-LeaveTypeServiceImpl insertleaveType()-started");
		try {
			log.info("{}-LeaveTypeServiceImpl insertleaveType()-started in leaveTypeRepo");
			LeaveType leave=leaveTypeDAO.save(leaveType);
			if(leave!=null) {
				return leave.getLeaveTypeId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			log.error("{}-LeaveTypeServiceImpl insertleaveType()-exception occured",e.getMessage());
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<LeaveType> getLeaveTypes() {
		try {
			return leaveTypeDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public LeaveType getLeaveType(Integer leaveTypeId) {
		try {
			return leaveTypeDAO.findById(leaveTypeId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateLeaveType(LeaveType leaveType) {
		try {
			if(leaveType!=null) {
			leaveTypeDAO.save(leaveType);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteLeaveType(Integer leaveTpeId) {
		try {
			leaveTypeDAO.deleteById(leaveTpeId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}
}
