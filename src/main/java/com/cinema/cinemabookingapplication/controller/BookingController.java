package com.cinema.cinemabookingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinemabookingapplication.entity.Movie;
import com.cinema.cinemabookingapplication.exception.MovieNotFoundException;
import com.cinema.cinemabookingapplication.service.MovieService;

@RestController
@RequestMapping(value = "api/booking")
public class BookingController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/getMovie", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getMovie() throws MovieNotFoundException {
		List<Movie> movie = movieService.getAllMoviesDetails();

		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	@GetMapping("/{movieId}")
    public ResponseEntity<Object> getMoviesBasedOnId(@PathVariable(name = "movieId") int movieId) throws MovieNotFoundException {
		Movie movie = movieService.getMovieDetails(movieId);
		return new ResponseEntity<>(movie,HttpStatus.OK);
	}
	
	@PutMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateMovieDetails(@RequestBody Movie movie,@PathVariable(name = "movieId") int movieId) throws MovieNotFoundException {

        Movie storedMovie = movieService.getMovieDetails(movieId);

        //Movie movieToBeUpdated = modelMapper.map(movie, Movie.class);
        Movie movieToBeUpdated =null;
        Movie savedMovie = movieService.updateMovieDetails(movieId,movieToBeUpdated);

       // Movie savedResponse = modelMapper.map(savedMovie,Movie.class);
        Movie savedResponse = null;
        return new ResponseEntity<Object>(savedResponse,HttpStatus.ACCEPTED);
    }
	
	 @DeleteMapping(value = "/{movie_id}")
	    public ResponseEntity<Object> deleteMovie(@PathVariable(name = "movie_id") int id) throws MovieNotFoundException {
	        movieService.deleteMovie(id);

	        return new ResponseEntity<Object>("DELETED",HttpStatus.OK);
	    }
}