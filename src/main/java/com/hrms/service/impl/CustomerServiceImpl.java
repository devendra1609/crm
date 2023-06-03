package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.CustomerDAO;
import com.hrms.dao.model.Customer;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {
		try {
			return customerDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		try {
			return customerDAO.findById(customerId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public Integer insertCustomer(Customer customer) {
		try {
			Customer cust=customerDAO.save(customer);
			if(cust!=null) {
				return cust.getCustomerId();
			}else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			if(customer!=null) {
				customerDAO.save(customer);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		try {
			customerDAO.deleteById(customerId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}
}
