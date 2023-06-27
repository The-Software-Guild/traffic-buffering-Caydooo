package com.trackfic.service;

import java.util.List;

import com.trackfic.dao.WitnessDaoInterface;
import com.trackfic.model.Witness;

public class WitnessDaoStubImpl implements WitnessDaoInterface {

	public Witness singleWitness;

	public WitnessDaoStubImpl() {
		singleWitness = new Witness("email", "firstName", "lastName", 1, "1");
	}

	@Override
	public Witness createNewWitness(Witness witness) {
		if (witness.getEmail().equals("") || witness.getFirstName().equals("") || witness.getLastName().equals("")) {
			return null;
		}
		return witness;

	}

	@Override
	public List<Witness> getAllWitnesss() {
		// Pass through method no tests
		return null;
	}

	@Override
	public Witness findWitnessByEmail(String email) {
		if (singleWitness.getEmail().equals(email)) {
			return singleWitness;
		}

		return null;
	}

	@Override
	public void updateWitness(Witness witness) {
		// Doesn't return so no tests

	}

	@Override
	public void deleteWitness(String email) {
		// Pass through method no tests
	}

	@Override
	public Witness login(String email, String password) {

		if (singleWitness.getEmail().equals(email) && singleWitness.getPassword().equals(password)) {
			return singleWitness;
		}
		return null;
	}

}
