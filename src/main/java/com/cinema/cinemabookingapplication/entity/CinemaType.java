package com.cinema.cinemabookingapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Cinema")
public class CinemaType {
	@Id
	@Column(name = "CINEMA_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long CinemaId;
	@Column(name = "PVR")
	private String PVR;
	@Column(name = "Innox")
	private String Innox;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonIgnoreProperties("users")
    private Users users; 
	public CinemaType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCinemaId() {
		return CinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		CinemaId = cinemaId;
	}

	public String getPVR() {
		return PVR;
	}

	public void setPVR(String pVR) {
		PVR = pVR;
	}


	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getInnox() {
		return Innox;
	}

	public void setInnox(String innox) {
		Innox = innox;
	}

	

}
