package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.ProductStockDAO;
import com.hrms.dao.model.ProductStock;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.ProductStockService;

@Service
public class ProductStockServiceImpl implements ProductStockService{
	@Autowired
	private ProductStockDAO productStockDAO;

	@Override
	public Integer insertProductStock(ProductStock productStock) {
		try {
			ProductStock product=productStockDAO.save(productStock);
			if(product!=null) {
				return product.getProductId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<ProductStock> getProductStocks() {
		try {
			return productStockDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public ProductStock getProductStock(Integer productStockId) {
		try {
			return productStockDAO.findById(productStockId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateProductStock(ProductStock productStock) {
		try {
			if(productStock!=null) {
				productStockDAO.save(productStock);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteProductStock(Integer productStockId) {
		try {
			productStockDAO.deleteById(productStockId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

}
