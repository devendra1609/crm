package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.BranchTl;

public interface BranchService {
	public Integer insertBranch(BranchTl branchTl);
	public List<BranchTl> getBranches();
	public BranchTl getBranch(Integer branchId);
	public void updateBranch(BranchTl branchTl);
	public void deleteBranch(Integer branchId);
}
