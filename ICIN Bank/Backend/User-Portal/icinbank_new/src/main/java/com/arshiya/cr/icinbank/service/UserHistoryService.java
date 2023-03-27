package com.arshiya.cr.icinbank.service;

import java.util.List;

import com.arshiya.cr.icinbank.model.UserHistory;

public interface UserHistoryService {

	public UserHistory addAction(long account,int amount,int balance,String action);
	public List<UserHistory> getHistory(long account);
}
