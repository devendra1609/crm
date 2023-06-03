package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.LeaveType;

@Repository
public interface LeaveTypeDAO extends JpaRepository<LeaveType, Integer>{

}
