package com.se.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.se.entity.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUltility {
	
	private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static final String SECRET_KEY = "Hey PhanTanTan. This secret key must have at least 256 bit character like this.";
	
    
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
    
    public String generateHS512Token(UserPrincipal userPrincipal) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userPrincipal.getUsername());
    }
	private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }
	
	
	public Boolean validateToken(String token, UserPrincipal userPrincipal) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userPrincipal.getUsername()) && !isTokenExpired(token));
    }
	private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
	public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
}
