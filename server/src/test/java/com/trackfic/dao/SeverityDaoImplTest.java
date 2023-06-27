package com.trackfic.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.trackfic.enums.AccidentSeverity;
import com.trackfic.exception.SeverityNotFoundException;

//@DataJdbcTest
public class SeverityDaoImplTest {

	@Autowired
	private SeverityDaoImpl severityDao;

	public SeverityDaoImplTest() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/trackfics");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		severityDao = new SeverityDaoImpl(template);

	}

	@Test
	public void getOneTest() {
		AccidentSeverity severity = severityDao.findSeverityByValue("Major");
		assertEquals(severity, AccidentSeverity.valueOf("Major"));

		severity = severityDao.findSeverityByValue("Minor");
		assertEquals(severity, AccidentSeverity.valueOf("Minor"));

		severity = severityDao.findSeverityByValue("Severe");
		assertEquals(severity, AccidentSeverity.valueOf("Severe"));

		try {
			severity = severityDao.findSeverityByValue("Test");
			assertTrue(false);
		} catch (SeverityNotFoundException e) {
			assertTrue(true);
		}

	}
}