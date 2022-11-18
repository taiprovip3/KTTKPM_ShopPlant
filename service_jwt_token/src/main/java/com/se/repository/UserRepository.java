package com.se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.se.dto.UserDTO;
import com.se.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserByUsername(String username);
}
