package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.dao.model.ProductEntity;

public interface ProductDAO extends JpaRepository<ProductEntity, Integer>{

}
