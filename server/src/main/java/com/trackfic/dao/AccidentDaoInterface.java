package com.trackfic.dao;

import java.util.List;

import com.trackfic.model.Accident;

public interface AccidentDaoInterface {

	Accident createNewAccident(Accident accident);

	List<Accident> getAllAccidents();

	List<Accident> findAccidentsByWitnessEmail(String email);

	Accident findAccidentById(int id);

	void updateAccident(Accident accident);

	void deleteAccident(int id);

}
