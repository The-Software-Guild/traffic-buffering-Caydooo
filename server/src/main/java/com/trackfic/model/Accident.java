package com.trackfic.model;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.trackfic.enums.AccidentSeverity;

public class Accident {

	private int accidentId;
	private int vehicleCount;
	private Time accidentTime;
	private Date accidentDate;
	private String accidentDesc;

	@Min(value = 1, message = "Accident location is required")
	private int locationId;
	@Min(value = 1, message = "Accident type is required")
	private int accidentTypeId;
	@NotBlank(message = "Witness email is required")
	private String witnessEmail;

	private AccidentSeverity accidentSeverity;

	public Accident(int accidentId, int vehicleCount, Time accidentTime, Date accidentDate, String accidentDesc,
			int locationId, int accidentTypeId, String witnessEmail, AccidentSeverity accidentSeverity) {
		super();
		this.accidentId = accidentId;
		this.vehicleCount = vehicleCount;
		this.accidentTime = accidentTime;
		this.accidentDate = accidentDate;
		this.accidentDesc = accidentDesc;
		this.locationId = locationId;
		this.accidentTypeId = accidentTypeId;
		this.witnessEmail = witnessEmail;
		this.accidentSeverity = accidentSeverity;
	}

	public Accident() {
	}

	public int getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(int accidentId) {
		this.accidentId = accidentId;
	}

	public int getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}

	public Time getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(Time accidentTime) {
		this.accidentTime = accidentTime;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getAccidentDesc() {
		return accidentDesc;
	}

	public void setAccidentDesc(String accidentDesc) {
		this.accidentDesc = accidentDesc;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getAccidentTypeId() {
		return accidentTypeId;
	}

	public void setAccidentTypeId(int accidentTypeId) {
		this.accidentTypeId = accidentTypeId;
	}

	public String getWitnessEmail() {
		return witnessEmail;
	}

	public void setWitnessEmail(String witnessEmail) {
		this.witnessEmail = witnessEmail;
	}

	public AccidentSeverity getAccidentSeverity() {
		return accidentSeverity;
	}

	public void setAccidentSeverity(AccidentSeverity accidentSeverity) {
		this.accidentSeverity = accidentSeverity;
	}

}
