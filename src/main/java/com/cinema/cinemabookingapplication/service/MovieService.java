package com.cinema.cinemabookingapplication.service;

import java.util.List;

import com.cinema.cinemabookingapplication.entity.Movie;
import com.cinema.cinemabookingapplication.exception.MovieNotFoundException;

public interface MovieService {


	public Movie acceptMovieDetails(Movie movie) throws MovieNotFoundException;

	public Movie getMovieDetails(long id) throws MovieNotFoundException;

	public Movie updateMovieDetails(int id, Movie movie) throws MovieNotFoundException;

	public boolean deleteMovie(int id) throws MovieNotFoundException;

	public List<Movie> getAllMoviesDetails() throws MovieNotFoundException;
	
	public Movie save(Movie movie) throws MovieNotFoundException;

}
