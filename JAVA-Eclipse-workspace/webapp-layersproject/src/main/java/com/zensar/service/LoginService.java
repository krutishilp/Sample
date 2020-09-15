package com.zensar.service;

import com.zensar.repository.LoginRepository;

public class LoginService {

	public boolean isvalidUser(String userName, String password) {
		LoginRepository repository = new LoginRepository();
		return repository.isvalid(userName, password);
	}
}
