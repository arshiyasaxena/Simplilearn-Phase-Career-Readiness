package org.arshiya.fsd.cr.api.service;

import org.arshiya.fsd.cr.api.dto.ChargeRequest;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;

import com.stripe.model.Charge;

public interface StripeService {

	Charge charge(ChargeRequest chargeRequest) throws FoodBoxServiceException;

}
