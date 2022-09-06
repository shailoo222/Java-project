package com.cinema.cinemabookingapplication.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @Column(name = "MOVIE_ID")
    private long movieId;
	@Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;
    @Column(name = "SHOW_CYCLE")
    private LocalDate showCycle;
    public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id" ,referencedColumnName = "screen_id")
    private Screen screen;
   
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public LocalDate getShowCycle() {
		return showCycle;
	}
	public void setShowCycle(LocalDate showCycle) {
		this.showCycle = showCycle;
	}
	public Movie(String movieName, long movieId, LocalDate releaseDate, String sHOWcYCLE) {
		super();
		this.movieName = movieName;
		this.movieId = movieId;
		this.releaseDate = releaseDate;
		showCycle = showCycle;
	}
    
}
