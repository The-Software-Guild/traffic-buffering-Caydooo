package com.trackfic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trackfic.dao.WitnessDaoInterface;
import com.trackfic.exception.DataMismatchException;
import com.trackfic.model.Witness;

@Service
public class WitnessServiceImpl implements WitnessServiceInterface {

	Witness returnedWitness;

	WitnessDaoInterface witnessDao;

	public WitnessServiceImpl(WitnessDaoInterface witnessDao) {
		this.witnessDao = witnessDao;
		this.returnedWitness = new Witness();
	}

	public List<Witness> getAllWitnesses() {

		return witnessDao.getAllWitnesss();
	}

	public Witness getWitnessByEmail(String email) {

		returnedWitness = witnessDao.findWitnessByEmail(email);
		return returnedWitness;
	}

	public Witness addNewWitness(Witness witness) {
		returnedWitness = witnessDao.createNewWitness(witness);
		return returnedWitness;
	}

	public Witness updateWitnessData(String email, Witness witness) {

		if (!email.equals(witness.getEmail())) {
			// throw an error
			throw new DataMismatchException("Witness email does not match");
		}
		witnessDao.updateWitness(witness);
		return witness;
	}

	public void deleteWitness(String email) {

		witnessDao.deleteWitness(email);
	}

	@Override
	public Witness loginWitness(String email, String password) {
		return witnessDao.login(email, password);
	}

}
