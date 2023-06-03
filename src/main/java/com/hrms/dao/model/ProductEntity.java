package com.hrms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "PRODUCT_ENTITY")
@Data
public class ProductEntity {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	@Column( name = "CATEGORY")
	private String category;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	@Column(name = "IMAGE")
	private String image;
}
