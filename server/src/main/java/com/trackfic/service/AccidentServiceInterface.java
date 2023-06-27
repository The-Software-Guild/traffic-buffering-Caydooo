package com.trackfic.service;

import java.util.List;

import com.trackfic.exception.ForeignKeyDeletionException;
import com.trackfic.model.Accident;

public interface AccidentServiceInterface {

	List<Accident> getAllAccidents();

	Accident getAccidentById(int id);

	List<Accident> getAccidentsByWitnessEmail(String email);

	Accident addNewAccident(Accident accident);

	Accident updateAccidentData(int id, Accident accident);

	void deleteAccident(int id) throws ForeignKeyDeletionException;

}
