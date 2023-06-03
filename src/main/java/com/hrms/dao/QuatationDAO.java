package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.Quatation;

@Repository
public interface QuatationDAO extends JpaRepository<Quatation, Integer>{

}
