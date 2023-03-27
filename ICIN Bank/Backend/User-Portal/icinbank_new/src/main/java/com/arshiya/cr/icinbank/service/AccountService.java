package com.arshiya.cr.icinbank.service;

import com.arshiya.cr.icinbank.model.Account;
import com.arshiya.cr.icinbank.response.DepositResponse;
import com.arshiya.cr.icinbank.response.TransferResponse;
import com.arshiya.cr.icinbank.response.WithdrawResponse;

public interface AccountService {

	public Account newAccount(String username,int userId);
	public Account getAccount(String username);
	public DepositResponse deposit(long acc,int amount);
	public WithdrawResponse withdraw(long acc,int amount);
	public TransferResponse transfer(long saccount,long raccount,int amount);
	public Account getAccountDetails(long account);
	public Account updateAccount(Account account);
}
