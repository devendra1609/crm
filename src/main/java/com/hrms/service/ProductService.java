package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.ProductEntity;

public interface ProductService {
	public Integer insertProduct(ProductEntity productEntity);
	public List<ProductEntity> getProducts();
	public ProductEntity getProduct(Integer productId);
	public void updateProduct(ProductEntity productEntity);
	public void deleteProduct(Integer productId);
}
