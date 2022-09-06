package com.cinema.cinemabookingapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabookingapplication.entity.CinemaType;
import com.cinema.cinemabookingapplication.repository.CinemaTypeRepository;

@Service
public class CinemaSeviceImpl implements CinemaSevice {

	@Autowired
	private CinemaTypeRepository cinematypeRepository;
	@Override
	public Optional<CinemaType> getCinema(long id) {
		// TODO Auto-generated method stub
		Optional<CinemaType> cinemaType = cinematypeRepository.findById(id);
		if(cinemaType.isPresent()) {
			return cinemaType;
		}
		return null;
	}

}
