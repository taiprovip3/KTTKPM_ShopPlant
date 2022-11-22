package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.dto.UserDTO;
import com.se.entity.Token;
import com.se.entity.User;
import com.se.entity.UserPrincipal;
import com.se.service.TokenServices;
import com.se.service.UserServices;
import com.se.util.JwtUltility;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/service_jwt_token")
public class RestController {
	
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private JwtUltility jwtUltility;
	
	@Autowired
	private TokenServices tokenServices;
	
	@Autowired
	private AuthenticationManager authenticationManagerBean;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody UserDTO u) {
		return userServices.saveUser(u);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> signInUser(@RequestBody UserDTO u){
		
		UserPrincipal userPrincipal = userServices.getUserByUsername(u.getUsername());
		if(userPrincipal == null || !passwordEncoder.matches(u.getPassword(), userPrincipal.getPassword()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account password is wrong!");
		try {
			Authentication authentication = authenticationManagerBean.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("\n\n>> User: `" + u.getUsername() + "` sign in successfully!\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean isTokenUserExisted = tokenServices.checkTokenUser(u.getUsername());
		Token token = new Token();
		String tokenString = jwtUltility.generateHS512Token(userPrincipal);
		token.setToken(tokenString);
		token.setTokenExpDate(jwtUltility.getExpirationDateFromToken(tokenString));
		token.setUser(userServices.getUserByUserName(u.getUsername()));
		if(isTokenUserExisted)
			tokenServices.updateToken(token);
		else
			tokenServices.saveToken(token);
		return ResponseEntity.ok(token.getToken());
	}
	
	@GetMapping("/signout")
	public String signOut() {
		SecurityContextHolder.getContext();
		return "\n\n(!) Sign out account success\n\n";
	}
	
	@PostMapping("/JmsQueue")
	public User sendMessageQueue(@RequestBody UserDTO u) {
		User user = new User();
		try {
			user = userServices.getUserByUserName(u.getUsername());
			jmsTemplate.convertAndSend("inbound.topic", u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@PostMapping("/JmsTopic")
	public String createTopic(@RequestBody String topic_name) {
		return topic_name;
	}
}
