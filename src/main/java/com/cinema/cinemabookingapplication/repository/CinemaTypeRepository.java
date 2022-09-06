package com.cinema.cinemabookingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemabookingapplication.entity.CinemaType;

@Repository
public interface CinemaTypeRepository extends JpaRepository<CinemaType,Long> {
	Optional<CinemaType> findById(long id);

}
