package com.trackfic.service;

import java.util.List;

import com.trackfic.model.Location;

public interface LocationServiceInterface {
	List<Location> getAllLocations();

	Location getLocationById(int id);

	Location addNewLocation(Location location);

	Location updateLocationData(int id, Location location);

	void deleteLocation(int id);
}
