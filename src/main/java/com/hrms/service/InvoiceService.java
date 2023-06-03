package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.InvoiceTl;

public interface InvoiceService 
{
	public Integer insertInvoice(InvoiceTl invoiceTl);
	
	public List<InvoiceTl> getInvoices();
	
	public InvoiceTl getInvoice(Integer invoiceId);
	
	public void updateInvoice(InvoiceTl invoiceTl);
	
	public void deleteInvoice(Integer invoiceId);
}
