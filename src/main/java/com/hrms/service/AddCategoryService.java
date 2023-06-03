package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.AddCategory;

public interface AddCategoryService {
	public Integer insertAddCategory(AddCategory addCategory);
	public List<AddCategory> getAddCategories();
	public AddCategory getAddCategory(Integer categoryId);
	public void updateAddCategory(AddCategory addCategory);
	public void deleteAddCategory(Integer categoryId);
}
