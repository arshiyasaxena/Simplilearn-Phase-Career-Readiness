package org.arshiya.fsd.cr.api.service;

import java.util.List;

import org.arshiya.fsd.cr.api.dto.Category;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

public interface CategoryService {

	List<Category> getCategories(Boolean enabled) throws FoodBoxServiceException;

	Category getCategory(Long id) throws FoodBoxServiceException;

	Category createCategory(Category category) throws FoodBoxServiceException;

	Category updateCategory(Category category) throws FoodBoxServiceException;

	Category deleteCategory(Long id) throws FoodBoxServiceException;

	Category setEnabled(Long id, Boolean enabled) throws FoodBoxServiceException;

	byte[] getCategoryImage(Long id) throws FoodBoxServiceException;

}
