package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.Customer;

public interface CustomerService {
	public Integer insertCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomer(Integer customerId);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Integer customerId);
}
