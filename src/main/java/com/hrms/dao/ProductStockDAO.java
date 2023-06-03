package com.hrms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.ProductStock;
@Repository
@EnableJpaRepositories
public interface ProductStockDAO extends JpaRepository<ProductStock, Integer>{
	
}
