package com.trackfic.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.trackfic.enums.AccidentSeverity;
import com.trackfic.model.Accident;

//@DataJdbcTest
@TestMethodOrder(OrderAnnotation.class)
public class AccidentDaoImplTest {

	@Autowired
	private AccidentDaoImpl accidentDao;

	public AccidentDaoImplTest() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/trackfics");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		accidentDao = new AccidentDaoImpl(template);

	}

	// tests the create method of accident dao layer
	@Test
	@Order(1)
	public void createTest() {
//		Accident accident = new Accident(3, "Test");
		AccidentSeverity severity = AccidentSeverity.Major;
		Accident accident = new Accident(4, 1, new java.sql.Time(2, 20, 10), new Date(2020, 10, 23), "Description", 1,
				1, "johnr@email.com", severity);
		accidentDao.createNewAccident(accident);
		List<Accident> list = accidentDao.getAllAccidents();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	// tests the get all method of accident dao layer
	@Order(2)
	public void getAllTest() {
		List<Accident> list = accidentDao.getAllAccidents();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	// tests the find accident by id method of accident dao layer
	@Test
	@Order(3)
	public void getOneTest() {
		Accident accident = accidentDao.findAccidentById(4);
		assertNotNull(accident);
		assertEquals("Description", accident.getAccidentDesc());
	}

	// tests the update accident of accident dao layer
	@Test
	@Order(4)
	public void updateTest() {
		AccidentSeverity severity = AccidentSeverity.Major;
		Accident accident = new Accident(5, 1, new java.sql.Time(2, 20, 10), new Date(2020, 10, 23), "Description", 1,
				1, "johnr@email.com", severity);
		accidentDao.createNewAccident(accident);
		accident.setAccidentDesc("Test Description");
		accidentDao.updateAccident(accident);

		Accident returned = accidentDao.findAccidentById(5);
		assertEquals(returned.getAccidentDesc(), "Test Description");
	}

	// tests the delete accident of accident dao layer
	@Test
	@Order(5)
	public void deleteTest() {
		accidentDao.deleteAccident(4);
		accidentDao.deleteAccident(5);

		List<Accident> list = accidentDao.getAllAccidents();
		assertNotNull(list);
		assertEquals(3, list.size());
	}

	@Test
	@Order(6)
	public void getAccidentsByEmailTest() {
		List<Accident> list = accidentDao.findAccidentsByWitnessEmail("johnr@email.com");
		assertNotNull(list);
		assertEquals(1, list.size());
	}
}
