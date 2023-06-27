package com.trackfic.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.trackfic.dao.AccidentDaoInterface;
import com.trackfic.enums.AccidentSeverity;
import com.trackfic.model.Accident;

//class used to act as the Dao would without altering the DB
public class AccidentDaoStubImpl implements AccidentDaoInterface {

	public Accident singleAccident;

	public AccidentDaoStubImpl() {
		singleAccident = new Accident(1, 1, new java.sql.Time(11, 51, 10), new Date(2020, 10, 23), "accidentDesc", 1, 1,
				"email", AccidentSeverity.Major);
	}

	@Override
	public Accident createNewAccident(Accident accident) {
		if (accident.getAccidentDesc().equals("")) {
			return null;
		}
		return accident;

	}

	@Override
	public List<Accident> getAllAccidents() {
		// Pass through method no tests
		return null;
	}

	@Override
	public Accident findAccidentById(int id) {
		if (singleAccident.getAccidentId() == id) {
			return singleAccident;
		}

		return null;
	}

	@Override
	public void updateAccident(Accident accident) {
		// Doesn't return so no tests

	}

	@Override
	public void deleteAccident(int id) {
		// Pass through method no tests
	}

	@Override
	public List<Accident> findAccidentsByWitnessEmail(String email) {

		List<Accident> accidents = new ArrayList<>();

		if (singleAccident.getWitnessEmail().equals(email)) {
			accidents.add(singleAccident);
		}

		return accidents;
	}

}
