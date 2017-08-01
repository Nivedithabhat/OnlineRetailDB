package com.sam.service.impl;

import com.sam.dao.LoginDao;
import com.sam.dao.impl.LoginDaoImpl;
import com.sam.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao logindao;

	public LoginServiceImpl() {
		logindao = new LoginDaoImpl();
	}

	@Override
	public int loginValidate(String username, String password) {
	
		return logindao.loginValidate(username, password);
		
	}

}
