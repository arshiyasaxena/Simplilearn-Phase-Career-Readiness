package com.arshiya.cr.icinbank.service;

import com.arshiya.cr.icinbank.model.Saccount;
import com.arshiya.cr.icinbank.response.DepositResponse;
import com.arshiya.cr.icinbank.response.TransferResponse;
import com.arshiya.cr.icinbank.response.WithdrawResponse;

public interface SaccountService {
	public Saccount getAccountDetails(long account);
	public Saccount getAccount(String username);
	public Saccount newAccount(String username,int userId);
	public DepositResponse deposit(long acc,int amount);
	public WithdrawResponse withdraw(long acc,int amount);
	public TransferResponse transfer(long saccount,long raccount,int amount);
}

