package com.arshiya.cr.icinbank.service;

import com.arshiya.cr.icinbank.details.UpdateDetails;
import com.arshiya.cr.icinbank.model.User;
import com.arshiya.cr.icinbank.model.UserDisplay;
import com.arshiya.cr.icinbank.response.UpdateResponse;

public interface ProfileService {
	public UpdateResponse updateUser(UpdateDetails user);
	public User getUser(String username);
	public UserDisplay userDisplay(String username);

}
