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

import com.hrms.dao.model.AddCategory;
import com.hrms.service.AddCategoryService;

@RestController
public class AddCategoryController {
	@Autowired
	private AddCategoryService addCategoryService;
	@PostMapping("/insertAddCategory")
	public ResponseEntity<Integer> insertAddCategory(@RequestBody AddCategory addCategory){
		try {
			Integer categoryId=addCategoryService.insertAddCategory(addCategory);
			return new ResponseEntity<Integer>(categoryId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAddcategories")
	public ResponseEntity<List<AddCategory>> getAddCategories(){
		try {
			return new ResponseEntity<List<AddCategory>>(addCategoryService.getAddCategories(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AddCategory>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getAddCategory/{categoryId}")
	public ResponseEntity<AddCategory> getAddCategory(@PathVariable Integer categoryId){
		try {
			AddCategory category=addCategoryService.getAddCategory(categoryId);
			return new ResponseEntity<AddCategory>(category,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AddCategory>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateAddCategory")
	public ResponseEntity<Void> updateAddCategory(@RequestBody AddCategory addCategory){
		try {
			addCategoryService.updateAddCategory(addCategory);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteAddCategory/{categoryId}")
	public ResponseEntity<Void> deleteAddCategory(@PathVariable Integer categoryId){
		try {
			addCategoryService.deleteAddCategory(categoryId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
