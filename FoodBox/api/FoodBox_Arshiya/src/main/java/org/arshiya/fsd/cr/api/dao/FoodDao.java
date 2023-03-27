package org.arshiya.fsd.cr.api.dao;

import java.math.BigDecimal;

import org.arshiya.fsd.cr.api.dto.Category;
import org.arshiya.fsd.cr.api.dto.Food;
import org.arshiya.fsd.cr.api.dto.Foods;
import org.arshiya.fsd.cr.api.dto.Offer;
import org.arshiya.fsd.cr.api.dto.PageInfo;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;

public interface FoodDao {

	Food getFood(Long id) throws FoodBoxDaoException;

	Foods getFoods(PageInfo pageInfo) throws FoodBoxDaoException;

	Foods getFoodsByName(String name, PageInfo pageInfo) throws FoodBoxDaoException;

	Foods getFoodsByCategory(Category category, PageInfo pageInfo) throws FoodBoxDaoException;

	Foods getFoodsByPrice(BigDecimal price, PageInfo pageInfo) throws FoodBoxDaoException;

	Foods getFoodsByOffer(Offer offer, PageInfo pageInfo) throws FoodBoxDaoException;

	Foods getFoodsByCategoryAndOffer(Category category, Offer offer, PageInfo pageInfo) throws FoodBoxDaoException;

	Foods search(String keyword, PageInfo pageInfo) throws FoodBoxDaoException;

	Food save(Food food) throws FoodBoxDaoException;

	Food update(Food food) throws FoodBoxDaoException;

	void remove(Long id) throws FoodBoxDaoException;

	void setEnabled(Long id, Boolean enabled) throws FoodBoxDaoException;

	byte[] getFoodImage(Long id) throws FoodBoxDaoException;

}
