package com.trackfic.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.trackfic.model.AccidentType;

//@DataJdbcTest
@TestMethodOrder(OrderAnnotation.class)
public class AccidentTypeDaoImplTest {
	@Autowired
	private AccidentTypeDaoImpl accidentTypeDao;

	public AccidentTypeDaoImplTest() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/trackfics");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		accidentTypeDao = new AccidentTypeDaoImpl(template);

	}

	@Test
	@Order(1)
	public void createTest() {
		AccidentType accidentType = new AccidentType(4, "Test");
		accidentTypeDao.createNewAccidentType(accidentType);
		List<AccidentType> list = accidentTypeDao.getAllAccidentTypes();
		assertNotNull(list);
		assertEquals(11, list.size());
	}

	@Test
	@Order(2)
	public void getAllTest() {
		List<AccidentType> list = accidentTypeDao.getAllAccidentTypes();
		assertNotNull(list);
		assertEquals(11, list.size());
	}

	@Test
	@Order(3)
	public void getOneTest() {
		AccidentType accidentType = accidentTypeDao.findAccidentTypeById(11);
		assertNotNull(accidentType);
		assertEquals("Test", accidentType.getAccidentType());
	}

	@Test
	@Order(4)
	public void updateTest() {
		AccidentType accidentType = new AccidentType(12, "Test2");
		accidentTypeDao.createNewAccidentType(accidentType);
		accidentType.setAccidentType("NotTest");
		accidentTypeDao.updateAccidentType(accidentType);

		AccidentType returned = accidentTypeDao.findAccidentTypeById(12);
		assertEquals(returned.getAccidentType(), "NotTest");
	}

	@Test
	@Order(5)
	public void deleteTest() {
		accidentTypeDao.deleteAccidentType(11);
		accidentTypeDao.deleteAccidentType(12);

		List<AccidentType> list = accidentTypeDao.getAllAccidentTypes();
		assertNotNull(list);
		assertEquals(10, list.size());
	}
}
