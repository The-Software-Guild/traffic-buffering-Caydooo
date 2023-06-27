package com.trackfic.dao;

import java.util.List;

import com.trackfic.model.AccidentType;

public interface AccidentTypeDaoInterface {

	AccidentType createNewAccidentType(AccidentType accidentType);

	List<AccidentType> getAllAccidentTypes();

	AccidentType findAccidentTypeById(int id);

	void updateAccidentType(AccidentType accidentType);

	void deleteAccidentType(int id);

}
