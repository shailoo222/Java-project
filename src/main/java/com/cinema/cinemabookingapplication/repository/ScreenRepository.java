package com.cinema.cinemabookingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinemabookingapplication.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long>{
	
	Optional<Screen> findByScreenType(String type);
	
	Optional<Screen> findById(long id);

}
