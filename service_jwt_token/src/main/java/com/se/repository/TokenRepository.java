package com.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long>{
	@Query("SELECT token FROM Token token WHERE token.user.username = ?1")
	public Token findTokenByUsername(String username);
	@Modifying
	@Query("UPDATE Token t SET t.token = ?2 WHERE t.user.id = ?1")
	public void updateToNewToken(long id, String token);
}
