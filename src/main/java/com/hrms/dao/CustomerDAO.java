package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.Customer;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
