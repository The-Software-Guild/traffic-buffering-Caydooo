package com.trackfic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trackfic.dao.AccidentDaoInterface;
import com.trackfic.exception.DataMismatchException;
import com.trackfic.exception.SeverityNotFoundException;
import com.trackfic.model.Accident;

@Service
public class AccidentServiceImpl implements AccidentServiceInterface {

	Accident returnedAccident;

	AccidentDaoInterface accidentDao;

	public AccidentServiceImpl(AccidentDaoInterface accidentDao) {
		this.accidentDao = accidentDao;
		this.returnedAccident = new Accident();
	}

	public List<Accident> getAllAccidents() {

		List<Accident> accidents = accidentDao.getAllAccidents();

		return accidents;
	}

	public Accident getAccidentById(int id) {

		returnedAccident = accidentDao.findAccidentById(id);

		return returnedAccident;
	}

	public Accident addNewAccident(Accident accident) {

		// safeguards against accident severity not being selected
		if (String.valueOf(accident.getAccidentSeverity()).equals("null")) {
			throw new SeverityNotFoundException("Accident severity not selected");
		}

		returnedAccident = accidentDao.createNewAccident(accident);

		return returnedAccident;
	}

	public Accident updateAccidentData(int id, Accident accident) {

		if (id != accident.getAccidentId()) {
			// throw an error
			throw new DataMismatchException("Accident id does not match");
		}
		accidentDao.updateAccident(accident);

		return accident;
	}

	public void deleteAccident(int id) {

		accidentDao.deleteAccident(id);

	}

	@Override
	public List<Accident> getAccidentsByWitnessEmail(String email) {

		return accidentDao.findAccidentsByWitnessEmail(email);
	}

}
