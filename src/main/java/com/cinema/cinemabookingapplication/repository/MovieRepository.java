package com.cinema.cinemabookingapplication.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemabookingapplication.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	Optional<Movie> findByReleaseDate(LocalDate date);

	Optional<Movie> findByShowCycle(LocalDate showCycle);
	
	List<Movie> findAll();
	
	Optional<Movie> findById(long id);
	
	Movie save(Movie movie);
}
