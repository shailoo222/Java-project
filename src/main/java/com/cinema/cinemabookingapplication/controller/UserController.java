package com.cinema.cinemabookingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cinema.cinemabookingapplication.entity.Movie;
import com.cinema.cinemabookingapplication.entity.Response;
import com.cinema.cinemabookingapplication.entity.Screen;
import com.cinema.cinemabookingapplication.entity.Users;
import com.cinema.cinemabookingapplication.exception.MovieNotFoundException;
import com.cinema.cinemabookingapplication.service.MovieService;
import com.cinema.cinemabookingapplication.service.ScreenService;

@RestController
@RequestMapping(value="public/api")
public class UserController {
	
	@Autowired
	private ScreenService screenservice;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String viewUserLoginPage() {
		return "user_login";
	}
	
	@RequestMapping(value ="/home1", method = RequestMethod.GET)
	public String viewUserHomePage() {
		return "user_home";
	}	
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public Screen getScreenName(@RequestBody Screen screen) {
		logger.info("Get Screen Request received using parameters:-{} ---{}", screen.getScreenType());

		return screenservice.getScreenType(screen.getScreenType());

	}
	
	@RequestMapping(value = "/getScreen", method = RequestMethod.GET)
	public Screen getScreenNameId(@RequestParam long id) {
		logger.info("Get Screen Request received using parameters:-{} ---{}", id);

		return screenservice.getScreenId(id);

	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ResponseEntity<Response> authenticateUser(@RequestBody Users usersRequest,
		 HttpServletResponse httpResponse) {
		logger.info("login request received for loginID :-{}", usersRequest.getUsername());
		//return usersRequest;
		return new ResponseEntity<Response>(
				new Response(HttpStatus.OK, HttpStatus.OK.value(), "Login Successful",
						usersRequest),
				HttpStatus.OK);
	}
	
}
