package com.cinema.cinemabookingapplication.entity;

import java.util.Date;
import java.time.LocalDate;

public class ErrorMessage {
	private int statusCode;

	private Date date;
	private String message;
	private String description;

	public ErrorMessage(int statusCode, java.util.Date date, String message, String description) {
		this.statusCode = statusCode;
		this.date = date;
		this.message = message;
		this.description = description;
	}

	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date timestamp) {
		this.date = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
