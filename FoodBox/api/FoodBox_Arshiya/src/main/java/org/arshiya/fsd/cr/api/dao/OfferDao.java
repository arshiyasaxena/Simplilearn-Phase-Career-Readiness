package org.arshiya.fsd.cr.api.dao;

import java.util.List;

import org.arshiya.fsd.cr.api.dto.Offer;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;

public interface OfferDao {

	Offer getOffer(Long id) throws FoodBoxDaoException;

	List<Offer> getOffers() throws FoodBoxDaoException;

	Offer save(Offer offer) throws FoodBoxDaoException;

	void remove(Long id) throws FoodBoxDaoException;

}
