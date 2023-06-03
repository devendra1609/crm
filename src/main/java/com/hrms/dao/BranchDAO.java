package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.BranchTl;

@Repository
public interface BranchDAO extends JpaRepository<BranchTl, Integer>{

}
