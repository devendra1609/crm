package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.ProductDAO;
import com.hrms.dao.model.ProductEntity;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;

	@Override
	public Integer insertProduct(ProductEntity productEntity) {
		try {
			ProductEntity product=productDAO.save(productEntity);
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
	public List<ProductEntity> getProducts() {
		try {
			return productDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public ProductEntity getProduct(Integer productId) {
		try {
			return productDAO.findById(productId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateProduct(ProductEntity productEntity) {
		try {
			if(productEntity!=null) {
				productDAO.save(productEntity);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void deleteProduct(Integer productId) {
		try {
			productDAO.deleteById(productId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}
}
