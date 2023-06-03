package com.hrms.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ADD_CATEGORY")
@Data
public class AddCategory {
	@Id
	@GeneratedValue
	@Column
	private Integer categoryId;
	@Column
	private String categoryName;
	@Column
	private String categoryDescription;
}
