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

import com.trackfic.model.Witness;

@TestMethodOrder(OrderAnnotation.class)
public class WitnessDaoImplTest {

	@Autowired
	private WitnessDaoImpl witnessDao;

	public WitnessDaoImplTest() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/trackfics");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		witnessDao = new WitnessDaoImpl(template);

	}

	@Test
	@Order(1)
	public void createTest() {
		Witness witness = new Witness("test1@email.com", "Test", "User", 1234, "1");
		witnessDao.createNewWitness(witness);
		List<Witness> list = witnessDao.getAllWitnesss();
		assertNotNull(list);
		assertEquals(6, list.size());
	}

	@Test
	@Order(2)
	public void getAllTest() {
		List<Witness> list = witnessDao.getAllWitnesss();
		assertNotNull(list);
		assertEquals(6, list.size());
	}

	@Test
	@Order(3)
	public void getOneTest() {
		Witness witness = witnessDao.findWitnessByEmail("test1@email.com");
		assertNotNull(witness);
		assertEquals("Test", witness.getFirstName());
	}

	@Test
	@Order(4)
	public void updateTest() {
		Witness witness = new Witness("test2@email.com", "Test", "User", 1234, "1");
		witnessDao.createNewWitness(witness);
		witness.setLastName("Lastname");
		witnessDao.updateWitness(witness);

		Witness returned = witnessDao.findWitnessByEmail(witness.getEmail());
		assertEquals(returned.getLastName(), "Lastname");
	}

	@Test
	@Order(5)
	public void deleteTest() {
		witnessDao.deleteWitness("test1@email.com");
		witnessDao.deleteWitness("test2@email.com");
//		assertNull(witnessDao.getAllWitnesss());

		List<Witness> list = witnessDao.getAllWitnesss();
		assertNotNull(list);
		assertEquals(5, list.size());
	}
}
