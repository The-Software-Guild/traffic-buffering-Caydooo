package com.trackfic.service;

import java.util.List;

import com.trackfic.dao.LocationDaoInterface;
import com.trackfic.model.Location;

public class LocationDaoStubImpl implements LocationDaoInterface {

	public Location singleLocation;

	public LocationDaoStubImpl() {
		singleLocation = new Location(1, "streetName", "streetNumber", "suburb", 1, "state", 0, 0);
	}

	@Override
	public Location createNewLocation(Location location) {
		if (location.getState().equals("")) {
			return null;
		}
		return location;

	}

	@Override
	public List<Location> getAllLocations() {
		// Pass through method no tests
		return null;
	}

	@Override
	public Location findLocationById(int id) {
		if (singleLocation.getLocationId() == id) {
			return singleLocation;
		}

		return null;
	}

	@Override
	public void updateLocation(Location location) {
		// Doesn't return so no tests

	}

	@Override
	public void deleteLocation(int id) {
		// Pass through method no tests
	}

}
