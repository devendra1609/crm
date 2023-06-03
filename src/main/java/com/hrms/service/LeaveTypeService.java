package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.LeaveType;

public interface LeaveTypeService {
	public Integer insertLeaveType(LeaveType leaveType);
	public List<LeaveType> getLeaveTypes();
	public LeaveType getLeaveType(Integer leaveTypeId);
	public void updateLeaveType(LeaveType leaveType);
	public void deleteLeaveType(Integer leaveTpeId);
}
