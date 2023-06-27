package com.trackfic.service;

import java.util.List;

import com.trackfic.model.AccidentType;

public interface AccidentTypeServiceInterface {

	List<AccidentType> getAllAccidentTypes();

	AccidentType getAccidentTypeById(int id);

	AccidentType addNewAccidentType(AccidentType accidentType);

	AccidentType updateAccidentTypeData(int id, AccidentType accidentType);

	void deleteAccidentType(int id);

}
