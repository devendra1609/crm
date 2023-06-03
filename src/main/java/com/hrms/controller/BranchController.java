package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dao.model.BranchTl;
import com.hrms.service.BranchService;

@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;
	@PostMapping("/insertBranch")
	public ResponseEntity<Integer> insertBranch(@RequestBody BranchTl branchTl){
		try {
			Integer branchId=branchService.insertBranch(branchTl);
			return new ResponseEntity<Integer>(branchId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBranches")
	public ResponseEntity<List<BranchTl>> getBranches(){
		try {
			return new ResponseEntity<List<BranchTl>>(branchService.getBranches(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<BranchTl>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBranch/{branchId}")
	public ResponseEntity<BranchTl> getBranch(@PathVariable Integer branchId){
		try {
			BranchTl branch=branchService.getBranch(branchId);
			return new ResponseEntity<BranchTl>(branch,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BranchTl>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateBranch")
	public ResponseEntity<Void> updateBranch(@RequestBody BranchTl branchTl){
		try {
			branchService.updateBranch(branchTl);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteBranch/{branchId}")
	public ResponseEntity<Void> deleteBranch(@PathVariable Integer branchId){
		try {
			branchService.deleteBranch(branchId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
