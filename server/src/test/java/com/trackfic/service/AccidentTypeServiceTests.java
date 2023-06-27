package com.trackfic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.trackfic.dao.AccidentTypeDaoInterface;
import com.trackfic.exception.DataMismatchException;
import com.trackfic.model.AccidentType;

public class AccidentTypeServiceTests {

	private AccidentTypeServiceImpl accidentTypeService;

	public AccidentTypeServiceTests() {
		AccidentTypeDaoInterface accidentTypeDao = new AccidentTypeDaoStubImpl();
		accidentTypeService = new AccidentTypeServiceImpl(accidentTypeDao);

	}

	@Test
	public void createAccidentTypeTest() {
		AccidentType temp = new AccidentType(1, "accidentType");
		AccidentType test = accidentTypeService.addNewAccidentType(temp);

		assertEquals(temp, test);

		temp = new AccidentType();
		temp.setAccidentType("");
		test = accidentTypeService.addNewAccidentType(temp);

		assertNull(test);

	}

	@Test
	public void updateAccidentTypeTest() {
		AccidentType temp = new AccidentType(1, "accidentType");
		AccidentType test = accidentTypeService.updateAccidentTypeData(1, temp);

		assertEquals(temp, test);

		try {
			temp = accidentTypeService.updateAccidentTypeData(2, temp);
			assertTrue(false);
		} catch (DataMismatchException e) {
			assertTrue(true);
		}

	}

	@Test
	public void findAccidentTypeByIdTest() {
		AccidentType temp = new AccidentType(1, "accidentType");
		AccidentType test = accidentTypeService.getAccidentTypeById(1);
		assertEquals(temp.getAccidentType(), test.getAccidentType());
		test = accidentTypeService.getAccidentTypeById(2);
		assertNull(test);

	}

}
