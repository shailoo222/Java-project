package com.cinema.cinemabookingapplication.service;

import com.cinema.cinemabookingapplication.entity.Screen;


public interface ScreenService {
	
	public Screen getScreenType(String type);
	
	public Screen getScreenId(long id);

}
