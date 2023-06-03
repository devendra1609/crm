package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.ProductStock;

public interface ProductStockService {
	public Integer insertProductStock(ProductStock productStock);
	public List<ProductStock> getProductStocks();
	public ProductStock getProductStock(Integer productStockId);
	public void updateProductStock(ProductStock productStock);
	public void deleteProductStock(Integer productStockId);
}
