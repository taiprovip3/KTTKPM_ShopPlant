package com.se.service;

import com.se.dto.UserDTO;
import com.se.entity.User;
import com.se.entity.UserPrincipal;

public interface UserServices {
	public User saveUser(UserDTO u);

	public UserPrincipal getUserByUsername(String username);
	
	public User getUserByUserName(String username);
}
