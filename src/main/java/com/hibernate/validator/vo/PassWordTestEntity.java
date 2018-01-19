package com.hibernate.validator.vo;

import com.hibernate.validator.annotations.Password;

public class PassWordTestEntity {

	@Password
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
