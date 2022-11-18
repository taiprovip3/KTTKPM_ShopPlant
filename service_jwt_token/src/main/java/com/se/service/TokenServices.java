package com.se.service;

import com.se.entity.Token;

public interface TokenServices {
	public void saveToken(Token token);

	public boolean checkTokenUser(String username);

	public void updateToken(Token token);
}
