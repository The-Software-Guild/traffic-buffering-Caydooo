package com.trackfic.service;

import java.util.List;

import com.trackfic.dao.AccidentTypeDaoInterface;
import com.trackfic.model.AccidentType;

public class AccidentTypeDaoStubImpl implements AccidentTypeDaoInterface {

	public AccidentType singleAccidentType;

	public AccidentTypeDaoStubImpl() {
		singleAccidentType = new AccidentType(1, "accidentType");
	}

	@Override
	public AccidentType createNewAccidentType(AccidentType accidentType) {
		if (accidentType.getAccidentType().equals("")) {
			return null;
		}
		return accidentType;

	}

	@Override
	public List<AccidentType> getAllAccidentTypes() {
		// Pass through method no tests
		return null;
	}

	@Override
	public AccidentType findAccidentTypeById(int id) {
		if (singleAccidentType.getTypeId() == id) {
			return singleAccidentType;
		}

		return null;
	}

	@Override
	public void updateAccidentType(AccidentType accidentType) {
		// Doesn't return so no tests

	}

	@Override
	public void deleteAccidentType(int id) {
		// Pass through method no tests
	}

}
