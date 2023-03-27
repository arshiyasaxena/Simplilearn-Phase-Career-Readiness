package org.arshiya.fsd.cr.api.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.arshiya.fsd.cr.api.dto.ChargeRequest;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeServiceImpl implements StripeService {

	@Value("${stripe.secret.key}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}

	@Override
	public Charge charge(ChargeRequest chargeRequest) throws FoodBoxServiceException {
		Map<String, Object> chargeParams = new HashMap<>();

		chargeParams.put("amount", chargeRequest.getAmount().longValue() * 100);
		chargeParams.put("currency", chargeRequest.getCurrency());
		chargeParams.put("description", chargeRequest.getDescription());
		chargeParams.put("source", chargeRequest.getStripeToken());
		chargeParams.put("receipt_email", chargeRequest.getStripeEmail());

		Charge charge = null;

		try {
			charge = Charge.create(chargeParams);
		} catch (StripeException e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return charge;
	}

}
