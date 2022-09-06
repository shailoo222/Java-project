package com.cinema.cinemabookingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemabookingapplication.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String userName);
	
}
