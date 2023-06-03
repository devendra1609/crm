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

import com.hrms.dao.model.Quatation;
import com.hrms.service.QuatationService;

@RestController
public class QuatationController {
	@Autowired
	private QuatationService quatationService;
	@PostMapping("/insertQuatation")
	public ResponseEntity<Integer> insertQuatation(@RequestBody Quatation quatation){
		try {
			Integer productId=quatationService.insertQuatation(quatation);
			return new ResponseEntity<Integer>(productId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getQuatations")
	public ResponseEntity<List<Quatation>> getQuatations(){
		try {
			return new ResponseEntity<List<Quatation>>(quatationService.getQuatations(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Quatation>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getquatation/{quatationId}")
	public ResponseEntity<Quatation> getQuatation(@PathVariable Integer productId){
		try {
			Quatation quat=quatationService.getQuatation(productId);
			return new ResponseEntity<Quatation>(quat,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Quatation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		@PostMapping("/updatequatation")
		public ResponseEntity<Void> updateQuatation(@RequestBody Quatation quatation)
		{
			try {
				quatationService.updateQuatation(quatation);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
			
		@PostMapping("/deleteQuatation/{quatationId}")
		public ResponseEntity<Void> deleteQuatation(@PathVariable Integer quatationId)
		{
			try {
				quatationService.deleteQuatation(quatationId);
				
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
