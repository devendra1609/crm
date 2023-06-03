package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dao.model.Role;
import com.hrms.service.RoleService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	@PostMapping("roles/insert")
	public ResponseEntity<Integer> saveUserType(@RequestBody Role role) {
		try {
			return new ResponseEntity<Integer>(roleService.insertUserType(role),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("roles/get")
	public ResponseEntity<List<Role>> getUserTypes(){
		try {
			List<Role> roles=roleService.getUserTypes();
			return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Role>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("roles/get/{userTypeId}")
	public ResponseEntity<Role> getuserType(@PathVariable Integer userTypeId){
		try {
			
			return new ResponseEntity<Role>(roleService.getUserType(userTypeId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Role>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("roles/update")
	public ResponseEntity<Void> updateUserType(@RequestBody Role role) {
		try {
			roleService.updateUserType(role);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	@GetMapping("roles/delete/{userTypeId}")
	public ResponseEntity<Void>  deleteUserType(@PathVariable Integer userTypeId) {
		try {
			roleService.deleteUserType(userTypeId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
