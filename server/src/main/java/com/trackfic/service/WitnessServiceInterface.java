package com.trackfic.service;

import java.util.List;

import com.trackfic.model.Witness;

public interface WitnessServiceInterface {
	List<Witness> getAllWitnesses();

	Witness getWitnessByEmail(String email);

	Witness addNewWitness(Witness witness);

	Witness loginWitness(String email, String password);

	Witness updateWitnessData(String email, Witness witness);

	void deleteWitness(String email);

}
