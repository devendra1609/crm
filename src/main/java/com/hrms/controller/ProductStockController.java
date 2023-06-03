package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hrms.dao.model.ProductStock;
import com.hrms.service.ProductStockService;

@Controller
public class ProductStockController {
	@Autowired
	private ProductStockService productStockService;
	@PostMapping("/insertproductstock")
	public ResponseEntity<Integer> insertProductStock(@RequestBody ProductStock productStock){
		try {
			Integer productStockId=productStockService.insertProductStock(productStock);
			return new ResponseEntity<Integer>(productStockId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getproductstocks")
	public ResponseEntity<List<ProductStock>> getProductStocks(){
		try {
			productStockService.getProductStocks();
			return new ResponseEntity<List<ProductStock>>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductStock>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getproductstock/{productstockid}")
	public ResponseEntity<ProductStock> getProductStock(@PathVariable Integer productStockId){
		try {
			return new ResponseEntity<ProductStock>(productStockService.getProductStock(productStockId),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductStock>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateproductstock")
	public ResponseEntity<Void> updateProductStock(@RequestBody ProductStock productStock){
		try {
			productStockService.updateProductStock(productStock);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteproductstock/{productStockId}")
	public ResponseEntity<Void> deleteProductStock(@PathVariable Integer productStockId){
		try {
			productStockService.deleteProductStock(productStockId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
