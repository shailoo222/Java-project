package com.cinema.cinemabookingapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemabookingapplication.entity.Movie;
import com.cinema.cinemabookingapplication.exception.MovieNotFoundException;
import com.cinema.cinemabookingapplication.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie acceptMovieDetails(Movie movie) {
		// TODO Auto-generated method stub
		Movie savemovie = new Movie();
		savemovie.setMovieId(movie.getMovieId());
		savemovie.setMovieName(movie.getMovieName());
		savemovie.setReleaseDate(movie.getReleaseDate());
		savemovie.setScreen(movie.getScreen());
		savemovie.setShowCycle(movie.getShowCycle());
		movieRepository.save(savemovie);
		return savemovie;
	}

	@Override
	public Movie getMovieDetails(long id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> findById = movieRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public Movie updateMovieDetails(int id, Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> findById = movieRepository.findById(id);
		if(findById.isPresent()) {
			 Movie getmovie = findById.get();
			 Movie updatemovie = new Movie();
			 updatemovie.setMovieId(getmovie.getMovieId());
			 updatemovie.setMovieName(getmovie.getMovieName());
			 updatemovie.setReleaseDate(getmovie.getReleaseDate());
			 updatemovie.setScreen(getmovie.getScreen());
			 updatemovie.setShowCycle(getmovie.getShowCycle());
				movieRepository.save(updatemovie);
			
		}
		return null;
	}

	@Override
	public boolean deleteMovie(int id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Movie> getAllMoviesDetails() {
		// TODO Auto-generated method stub
		List<Movie> findAll = movieRepository.findAll();
		return findAll;
	}

	@Override
	public Movie save(Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Movie savemovie = new Movie();
		savemovie.setMovieId(movie.getMovieId());
		savemovie.setMovieName(movie.getMovieName());
		savemovie.setReleaseDate(movie.getReleaseDate());
		savemovie.setScreen(movie.getScreen());
		savemovie.setShowCycle(movie.getShowCycle());
		movieRepository.save(savemovie);
		return savemovie;
	}
	

}
