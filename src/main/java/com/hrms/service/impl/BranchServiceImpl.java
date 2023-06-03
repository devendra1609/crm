package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.BranchDAO;
import com.hrms.dao.model.BranchTl;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService{
	@Autowired
	private BranchDAO branchDAO;

	@Override
	public Integer insertBranch(BranchTl branchTl) {
		try {
			BranchTl branch=branchDAO.save(branchTl);
			if(branch!=null) {
				return branch.getBranchId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<BranchTl> getBranches() {
		try {
			return branchDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public BranchTl getBranch(Integer branchId) {
		try {
			return branchDAO.findById(branchId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateBranch(BranchTl branchTl) {
		try {
			if(branchTl!=null) {
				branchDAO.save(branchTl);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteBranch(Integer branchId) {
		try {
			branchDAO.deleteById(branchId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}
	
}
