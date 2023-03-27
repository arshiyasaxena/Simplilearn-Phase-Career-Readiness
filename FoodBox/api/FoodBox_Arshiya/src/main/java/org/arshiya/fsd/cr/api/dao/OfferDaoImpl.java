package org.arshiya.fsd.cr.api.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dto.Offer;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;
import org.arshiya.fsd.cr.api.mapper.OfferMapper;
import org.arshiya.fsd.cr.api.repository.OfferRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OfferDaoImpl implements OfferDao {

	@Resource
	private OfferRepository repository;

	@Resource
	private OfferMapper mapper;

	@Override
	public Offer getOffer(Long id) throws FoodBoxDaoException {
		Offer offer = null;

		try {
			offer = repository.findById(id)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return offer;
	}

	@Override
	public List<Offer> getOffers() throws FoodBoxDaoException {
		List<Offer> offers = null;

		try {
			offers = repository.findAll().stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return offers;
	}

	@Override
	public Offer save(Offer offer) throws FoodBoxDaoException {
		Offer savedOffer = null;

		try {
			savedOffer = mapper.toDto(repository.save(mapper.toEntity(offer)));
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return savedOffer;
	}

	@Override
	public void remove(Long id) throws FoodBoxDaoException {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}
	}

}
