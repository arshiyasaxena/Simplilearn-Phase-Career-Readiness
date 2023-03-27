package org.arshiya.fsd.cr.api.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface OfferMapperService {

	default org.arshiya.fsd.cr.api.entity.Offer findById(Long id) {
		if (id == null) {
			return null;
		}

		org.arshiya.fsd.cr.api.entity.Offer offer = new org.arshiya.fsd.cr.api.entity.Offer();
		offer.setId(id);

		return offer;
	}

	default Long findByOffer(org.arshiya.fsd.cr.api.entity.Offer offer) {
		if (offer == null) {
			return null;
		}

		return offer.getId();
	}

}
