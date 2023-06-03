package com.hrms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUATATION")
public class Quatation {
	@Id
	@GeneratedValue
	@Column
	private Integer quatationId;
	private Integer productId;
	private String productName;
	private String mrpPrice;
	private String discount;
	private String quantity;
	private String salePrice;
	private String stock;
	public Integer getQuatationId() {
		return quatationId;
	}
	public void setQuatationId(Integer quatationId) {
		this.quatationId = quatationId;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMrpPrice() {
		return mrpPrice;
	}
	public void setMrpPrice(String mrpPrice) {
		this.mrpPrice = mrpPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	
}
