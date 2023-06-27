package com.trackfic.dao;

import java.util.List;

import com.trackfic.model.Witness;

public interface WitnessDaoInterface {

	Witness createNewWitness(Witness witness);

	List<Witness> getAllWitnesss();

	Witness findWitnessByEmail(String email);

	Witness login(String email, String password);

	void updateWitness(Witness witness);

	void deleteWitness(String email);

}
