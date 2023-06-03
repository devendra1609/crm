package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.ShipmentTl;

public interface ShipmentService
{
	public Integer insertShipment(ShipmentTl shipmentTl);
	
	public List<ShipmentTl> getShipments();
	
	public ShipmentTl getShipment(Integer shipmentId);
	
	public void updateShipment(ShipmentTl shipmentTl);
	
	public void deleteShipment(Integer shipmentId);
	
}
