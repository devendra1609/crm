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

import com.hrms.dao.model.Customer;
import com.hrms.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/customer/insert")
	public ResponseEntity<Integer> insertCustomer(@RequestBody Customer customer){
		try {
			Integer customerId=customerService.insertCustomer(customer);
			return new ResponseEntity<Integer>(customerId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers(){
		try {
			
			return new ResponseEntity<List<Customer>>(customerService.getCustomers(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer customerId){
		try {
			Customer cust=customerService.getCustomer(customerId);
			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateCustomer")
	public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
		try {
			customerService.updateCustomer(customer);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId){
		try {
			customerService.deleteCustomer(customerId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
