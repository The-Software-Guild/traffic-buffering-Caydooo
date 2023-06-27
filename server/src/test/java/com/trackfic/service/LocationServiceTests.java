package com.trackfic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.trackfic.dao.LocationDaoInterface;
import com.trackfic.exception.DataMismatchException;
import com.trackfic.model.Location;

public class LocationServiceTests {

	private LocationServiceImpl locationService;

	public LocationServiceTests() {
		LocationDaoInterface locationDao = new LocationDaoStubImpl();
		locationService = new LocationServiceImpl(locationDao);

	}

	@Test
	public void createLocationTest() {
		Location temp = new Location(1, "streetName", "streetNumber", "suburb", 1, "state", 0, 0);
		Location test = locationService.addNewLocation(temp);

		assertEquals(temp, test);

		temp = new Location();
		temp.setState("");
		test = locationService.addNewLocation(temp);

		assertNull(test);

	}

	@Test
	public void updateLocationTest() {
		Location temp = new Location(1, "streetName", "streetNumber", "suburb", 1, "state", 0, 0);
		Location test = locationService.updateLocationData(1, temp);

		assertEquals(temp, test);

		try {
			temp = locationService.updateLocationData(2, temp);
			assertTrue(false);
		} catch (DataMismatchException e) {
			assertTrue(true);
		}

	}

	@Test
	public void findLocationByIdTest() {
		Location temp = new Location(1, "streetName", "streetNumber", "suburb", 1, "state", 0, 0);
		Location test = locationService.getLocationById(1);
		assertEquals(temp.getStreetName(), test.getStreetName());
		test = locationService.getLocationById(2);
		assertNull(test);

	}

}
