package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.InvoiceDAO;
import com.hrms.dao.model.InvoiceTl;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.InvoiceService;
@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceDAO invoiceDAO;

	@Override
	public Integer insertInvoice(InvoiceTl invoiceTl) {
		try {
			InvoiceTl invoice=invoiceDAO.save(invoiceTl);
			
			if (invoice!= null) {
				return invoice.getCustomerId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public List<InvoiceTl> getInvoices() {
		
		try {
			return invoiceDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public InvoiceTl getInvoice(Integer invoiceId) {
		try {
			return invoiceDAO.findById(invoiceId).get();
			
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateInvoice(InvoiceTl invoiceTl) {
		try {
			if (invoiceTl!=null) {
				invoiceDAO.save(invoiceTl);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void deleteInvoice(Integer invoiceId) {
		try {
			invoiceDAO.deleteById(invoiceId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}
	
}
