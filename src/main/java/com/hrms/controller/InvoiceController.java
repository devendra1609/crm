package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dao.model.InvoiceTl;
import com.hrms.service.InvoiceService;


@RestController
public class InvoiceController 
{
	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/insertinvoice")
	public ResponseEntity<Integer> insertInvoice(@RequestBody InvoiceTl invoiceTl)
	{
		try {
			Integer customerId=invoiceService.insertInvoice(invoiceTl);
			return new ResponseEntity<Integer>(customerId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/getinvoices")
	public ResponseEntity<List<InvoiceTl>> getInvoices()
	{
		try {
			return new ResponseEntity<List<InvoiceTl>>(invoiceService.getInvoices(),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<List<InvoiceTl>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getinvoice/{invoiceId}")
	public ResponseEntity<InvoiceTl> getInvoice(@PathVariable Integer invoiceId)
	{
		try {
			InvoiceTl invoiceTl=invoiceService.getInvoice(invoiceId);
			
			return new ResponseEntity<InvoiceTl>(invoiceTl,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<InvoiceTl>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updateinvoice")
	public ResponseEntity<Void> updateInvoice(@RequestBody InvoiceTl invoiceTl)
	{
		try {
			invoiceService.updateInvoice(invoiceTl);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/deleteinvoice/{invoiceId}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Integer invoiceId)
	{
		try {
			invoiceService.deleteInvoice(invoiceId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
