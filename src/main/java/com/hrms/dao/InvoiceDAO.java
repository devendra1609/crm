package com.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dao.model.InvoiceTl;
@Repository
public interface InvoiceDAO extends JpaRepository<InvoiceTl, Integer>{

}
