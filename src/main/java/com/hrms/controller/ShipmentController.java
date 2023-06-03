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

import com.hrms.dao.model.ShipmentTl;
import com.hrms.service.ShipmentService;

@RestController
public class ShipmentController 
{
	@Autowired
	private ShipmentService shipmentService;
	
	@PostMapping("/insertshipment")
	public ResponseEntity<Integer> insertShipment(@RequestBody ShipmentTl shipmentTl)
	{
		try {
			Integer shipmentId=shipmentService.insertShipment(shipmentTl);
			return new ResponseEntity<Integer>(shipmentId,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getshipments")
	public ResponseEntity<List<ShipmentTl>> getShipments()
	{
		try {
			return new ResponseEntity<List<ShipmentTl>>(shipmentService.getShipments(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ShipmentTl>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getshipment/{shipmentId}")
	public ResponseEntity<ShipmentTl> getShipment(@PathVariable Integer shipmentId)
	{
		try {
			ShipmentTl shipment=shipmentService.getShipment(shipmentId);
			return new ResponseEntity<ShipmentTl>(shipment,HttpStatus.OK);
			
		} catch (Exception e) {
		return new ResponseEntity<ShipmentTl>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updateshipment")
	public ResponseEntity<Void> updateShipment(@RequestBody ShipmentTl shipmentTl)
	{
		
		try {
			shipmentService.updateShipment(shipmentTl);
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@GetMapping("/deleteshipment/{shipmentId}")
	public ResponseEntity<Void> deleteShipment(@PathVariable Integer shipmentId)
	{
		try {
			shipmentService.deleteShipment(shipmentId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
