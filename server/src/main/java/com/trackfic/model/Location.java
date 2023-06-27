package com.trackfic.model;

import javax.validation.constraints.NotBlank;

public class Location {

	private int locationId;
	@NotBlank(message = "Location street namestate is required")
	private String streetName;
	@NotBlank(message = "street number is required")
	private String streetNumber;
	@NotBlank(message = "Location suburb is required")
	private String suburb;
	private int postcode;
	@NotBlank(message = "Location state is required")
	private String state;
	private double latitude;
	private double longitude;

	public Location(int locationId, String streetName, String streetNumber, String suburb, int postcode, String state,
			double latitude, double longitude) {
		super();
		this.locationId = locationId;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location() {
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
