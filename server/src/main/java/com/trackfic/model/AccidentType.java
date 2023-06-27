package com.trackfic.model;

import javax.validation.constraints.NotBlank;

public class AccidentType {
	
	private int typeId;
	@NotBlank(message = "Accident type is required")
	private String accidentType;
	public AccidentType(int typeId, String accidentType) {
		super();
		this.typeId = typeId;
		this.accidentType = accidentType;
	}
	
	public AccidentType() {
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	
	
}