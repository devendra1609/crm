package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.AddCategoryDAO;
import com.hrms.dao.model.AddCategory;
import com.hrms.exception.EmployeeCustomException;
import com.hrms.service.AddCategoryService;
@Service
public class AddCategoryServiceImpl implements AddCategoryService{
	@Autowired
	private AddCategoryDAO addCategoryDAO;

	@Override
	public Integer insertAddCategory(AddCategory addCategory) {
		try {
			AddCategory category=addCategoryDAO.save(addCategory);
			if(category!=null){
				return category.getCategoryId();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public List<AddCategory> getAddCategories() {
		try {
			return addCategoryDAO.findAll();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public AddCategory getAddCategory(Integer categoryId) {
		try {
			return addCategoryDAO.findById(categoryId).get();
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}

	@Override
	public void updateAddCategory(AddCategory addCategory) {
		try {
			if(addCategory!=null) {
				addCategoryDAO.save(addCategory);
			}
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteAddCategory(Integer categoryId) {
		try {
			addCategoryDAO.deleteById(categoryId);
		} catch (Exception e) {
			throw new EmployeeCustomException(e.getMessage());
		}
	}
}
