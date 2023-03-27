package org.arshiya.fsd.cr.api.dao;

import java.util.List;

import org.arshiya.fsd.cr.api.dto.Fee;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;

public interface FeeDao {

	Fee getFee(String type) throws FoodBoxDaoException;

	List<Fee> getFees() throws FoodBoxDaoException;

	Fee save(Fee fee) throws FoodBoxDaoException;

	void remove(String type) throws FoodBoxDaoException;

}
