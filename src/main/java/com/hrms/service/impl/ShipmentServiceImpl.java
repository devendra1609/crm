package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.ShipmentDAO;
import com.hrms.dao.model.ShipmentTl;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.ShipmentService;
@Service
public class ShipmentServiceImpl implements ShipmentService {
	@Autowired
	private ShipmentDAO shipmentDAO;
	@Override
	public Integer insertShipment(ShipmentTl shipmentTl) {
		try {
			ShipmentTl shipment=shipmentDAO.save(shipmentTl);
			if (shipment!=null) {
				return shipment.getShipmentId();
				
			}else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<ShipmentTl> getShipments() {
		try {
			return shipmentDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public ShipmentTl getShipment(Integer shipmentId) {
		try {
			return shipmentDAO.findById(shipmentId).get();
			
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateShipment(ShipmentTl shipmentTl) {
		try {
			if (shipmentTl!=null) {
				shipmentDAO.save(shipmentTl);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteShipment(Integer shipmentId) {
	try {
		shipmentDAO.deleteById(shipmentId);
	} catch (Exception e) {
		throw new EmployeeCustomException(e.getMessage());
	}
		
	}

}
