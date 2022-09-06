package com.cinema.cinemabookingapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SCREEN")
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screenId;
    @Column(name = "SCREEN_TYPE")
    private String screenType;
    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL)
    private Movie movie;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CINEMA_ID", referencedColumnName = "CINEMA_ID")
    private CinemaType cinema;    
	public CinemaType getCinema() {
		return cinema;
	}
	public void setCinema(CinemaType cinema) {
		this.cinema = cinema;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public long getScreenId() {
		return screenId;
	}
	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public Screen(long screenId, String screenType) {
		super();
		this.screenId = screenId;
		this.screenType = screenType;
	}
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}
    

    
}
