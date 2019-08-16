package com.restful.webapp.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timeStamp;
	private String errorMessage;

	public ErrorMessage() {

	}

	public ErrorMessage(Date date, String message) {
		this.timeStamp = date;
		this.errorMessage = message;

	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [timeStamp=" + timeStamp + ", errorMessage=" + errorMessage + "]";
	}

}
