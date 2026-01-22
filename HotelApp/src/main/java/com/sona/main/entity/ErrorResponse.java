package com.sona.main.entity;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class ErrorResponse {

	 LocalDateTime timeStamp;
	 String errorDetails;
	 String errorMessage;
	 String errorCode;
	 
	 
	public ErrorResponse( String errorMessage, String errorDetails, String errorCode) {

		this.timeStamp = LocalDateTime.now();
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
		this.errorCode = errorCode;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getErrorDetails() {
		return errorDetails;
	}


	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	


	
	 
	 
	 
	 
	 
	
}
