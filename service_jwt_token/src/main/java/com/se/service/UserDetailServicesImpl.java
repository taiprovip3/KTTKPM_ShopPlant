package com.se.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServicesImpl implements UserDetailsService {

	@Autowired
	private UserServices userServices;
	
	@Override	//Hàm này trả về 1 object User Detail chứa (Username, Password, Authorities) và sẽ đc AuthManagerBuilder trong WebConfig giữ làm đối tượng đã login -> Nghĩa là: khi ta /login sẽ trả về 1 userDetails có kiêu impl là UserPrincipal chứa các thuộc tính và đc AuthManagerBuilder xác thực và giữ khi project chạy. AuthManagerBuilder sẽ bypass security khi config các / trong http.authenticated()
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userServices.getUserByUsername(username);
	}

}
