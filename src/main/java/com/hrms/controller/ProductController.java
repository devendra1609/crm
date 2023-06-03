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

import com.hrms.dao.model.ProductEntity;
import com.hrms.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/insertProduct")
	public ResponseEntity<Integer>saveProduct(@RequestBody ProductEntity productEntity){
		try {
			Integer productId=productService.insertProduct(productEntity);
			return new ResponseEntity<Integer>(productId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductEntity>>getProducts(){
		try {
			return new ResponseEntity<List<ProductEntity>>(productService.getProducts(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ProductEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer productId){
		try {
			ProductEntity productEntity=productService.getProduct(productId);
			return new ResponseEntity<ProductEntity>(productEntity,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateProduct")
	public ResponseEntity<Void>updateProduct(@RequestBody ProductEntity productEntity){
		try {
			productService.updateProduct(productEntity);
			return new ResponseEntity<Void>(HttpStatus.OK);
	} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteProduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable  Integer productId){
		try {
			productService.deleteProduct(productId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
