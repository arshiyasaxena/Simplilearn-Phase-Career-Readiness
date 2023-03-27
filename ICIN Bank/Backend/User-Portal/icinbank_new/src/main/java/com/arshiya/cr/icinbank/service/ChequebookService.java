package com.arshiya.cr.icinbank.service;

import java.util.List;

import com.arshiya.cr.icinbank.model.ChequebookRequest;
import com.arshiya.cr.icinbank.response.ChequeResponse;

public interface ChequebookService {

	public ChequeResponse createrequest(ChequebookRequest chequebook);
	public List<ChequebookRequest> getRequests(long account);
}
