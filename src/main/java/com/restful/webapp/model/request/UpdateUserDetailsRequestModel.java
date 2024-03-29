package com.restful.webapp.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull
	@Size(min = 2, message = "FirstName cannot be less than two characters")
	private String firstName;

	@NotNull
	@Size(min = 2, message = "FirstName cannot be less than two characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
