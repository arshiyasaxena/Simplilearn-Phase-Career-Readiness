package org.arshiya.fsd.cr.api.service;

import java.util.List;

import org.arshiya.fsd.cr.api.dto.Offer;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

public interface OfferService {

	List<Offer> getOffers() throws FoodBoxServiceException;

	Offer getOffer(Long id) throws FoodBoxServiceException;

	Offer createOffer(Offer offer) throws FoodBoxServiceException;

	Offer updateOffer(Offer offer) throws FoodBoxServiceException;

	Offer deleteOffer(Long id) throws FoodBoxServiceException;

}
