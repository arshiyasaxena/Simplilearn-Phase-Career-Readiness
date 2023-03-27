package com.arshiya.cr.icinbank.service;

import java.util.List;

import com.arshiya.cr.icinbank.model.Transfer;

public interface TransferHistoryService {

	public Transfer addAction(long saccount, long raccount, int amount);
	public List<Transfer> getTransfers(long account);
}
