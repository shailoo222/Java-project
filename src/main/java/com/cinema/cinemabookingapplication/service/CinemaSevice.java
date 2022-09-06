package com.cinema.cinemabookingapplication.service;

import java.util.Optional;

import com.cinema.cinemabookingapplication.entity.CinemaType;

public interface CinemaSevice {
	
	Optional<CinemaType> getCinema(long id);

}
