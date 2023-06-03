package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.AddCategory;
@Repository
public interface AddCategoryDAO extends JpaRepository<AddCategory, Integer>{

}
