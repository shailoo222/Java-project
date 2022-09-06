package com.cinema.cinemabookingapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabookingapplication.entity.Screen;
import com.cinema.cinemabookingapplication.repository.ScreenRepository;
import com.cinema.cinemabookingapplication.repository.UsersRepository;
@Service
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	private ScreenRepository screenRepository;
	@Autowired
	private UsersRepository userRepository;
	@Override
	public Screen getScreenType(String type) {
		// TODO Auto-generated method stub
		Optional<Screen> findByScreenType = screenRepository.findByScreenType(type);
		if(findByScreenType.isPresent()) {
			return findByScreenType.get();
		}
		return null;
	}
	@Override
	public Screen getScreenId(long id) {
		// TODO Auto-generated method stub
		Optional<Screen> findByScreenId = screenRepository.findById(id);
		if(findByScreenId.isPresent()) {
			return findByScreenId.get();
		}
		return null;
	}

}
