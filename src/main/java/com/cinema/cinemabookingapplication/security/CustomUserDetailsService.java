package com.cinema.cinemabookingapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cinema.cinemabookingapplication.entity.Users;
import com.cinema.cinemabookingapplication.repository.UsersRepository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired 
	private UsersRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with the given email");
		}
		
		return new CustomUserDetails(user);
	}

}
