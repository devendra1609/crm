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

import com.hrms.dao.model.LeaveType;
import com.hrms.service.LeaveTypeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LeaveTypeController {
	@Autowired
	private LeaveTypeService leaveTypeService;
	@PostMapping("/insertLeaveType")
	public ResponseEntity<Integer> insertLeaveType(@RequestBody LeaveType leaveType){
		log.info("{}-LeaveTypeController insertLeaveType()-started");
		try {
			log.info("{}-LeaveTypeController insertLeaveType()-save the leaveTypedetails");
			Integer leaveTypeId=leaveTypeService.insertLeaveType(leaveType);
			return new ResponseEntity<Integer>(leaveTypeId,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-LeaveTypeController insertLeaveType()-exception occured",e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getLeaveTypes")
	public ResponseEntity<List<LeaveType>> getLeaveTypes(){
		try {
			return new ResponseEntity<List<LeaveType>>(leaveTypeService.getLeaveTypes(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<LeaveType>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getLeaveType/{leaveTypeId}")
	public ResponseEntity<LeaveType> getLeaveType(@PathVariable Integer leaveTypeId){
		try {
			
		LeaveType leave=leaveTypeService.getLeaveType(leaveTypeId);
			return new ResponseEntity<LeaveType>(leave,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LeaveType>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateLeaveType")
	public ResponseEntity<Void> updateLeaveType(@RequestBody LeaveType leaveType){
		try {
			 leaveTypeService.updateLeaveType(leaveType);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteLeaveType/{leaveTypeId}")
	public ResponseEntity<Void> deleteLeaveType(@PathVariable Integer leaveTypeId){
		try {
			leaveTypeService.deleteLeaveType(leaveTypeId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
