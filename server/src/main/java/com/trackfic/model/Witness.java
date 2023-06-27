package com.trackfic.model;

import javax.validation.constraints.NotBlank;

public class Witness {

	@NotBlank(message = "Witness email is required")
	private String witnessEmail;
	@NotBlank(message = "Witness firstname is required")
	private String firstName;
	@NotBlank(message = "Witness lastname is required")
	private String lastName;
	private int mobile;
	@NotBlank(message = "Witness password is required")
	private String password;

	public Witness(String email, String firstName, String lastName, int mobile, String password) {
		super();
		this.witnessEmail = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.password = password;
	}

	public Witness() {
	}

	public String getEmail() {
		return witnessEmail;
	}

	public void setEmail(String email) {
		this.witnessEmail = email;
	}

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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
