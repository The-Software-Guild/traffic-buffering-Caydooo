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

import com.trackfic.model.Location;

@TestMethodOrder(OrderAnnotation.class)
public class LocationDaoImplTest {

	@Autowired
	private LocationDaoImpl locationDao;

	public LocationDaoImplTest() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/trackfics");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		locationDao = new LocationDaoImpl(template);

	}

	@Test
	@Order(1)
	public void createTest() {
		Location location = new Location(1, "streetName", "1", "suburb", 1, "NSW", 1, 1);
		locationDao.createNewLocation(location);
		List<Location> list = locationDao.getAllLocations();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	@Test
	@Order(2)
	public void getAllTest() {
		List<Location> list = locationDao.getAllLocations();
		assertNotNull(list);
		assertEquals(4, list.size());
	}

	@Test
	@Order(3)
	public void getOneTest() {
		Location location = locationDao.findLocationById(1);
		assertNotNull(location);
		assertEquals("Kellyville", location.getSuburb());
	}

	@Test
	@Order(4)
	public void updateTest() {
		Location location = new Location(5, "Test Street", "2", "Test Suburb", 1, "NSW", 0, 0);
		locationDao.createNewLocation(location);
		location.setSuburb("New Suburb");
		locationDao.updateLocation(location);

		Location returned = locationDao.findLocationById(5);
		assertEquals(returned.getSuburb(), "New Suburb");
	}

	@Test
	@Order(5)
	public void deleteTest() {
		locationDao.deleteLocation(4);
		locationDao.deleteLocation(5);

//		assertNull(locationDao.getAllLocations());

		List<Location> list = locationDao.getAllLocations();
		assertNotNull(list);
		assertEquals(3, list.size());
	}
}
