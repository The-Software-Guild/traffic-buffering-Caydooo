package com.trackfic.dao;

import java.util.List;

import com.trackfic.model.Location;

public interface LocationDaoInterface {

	Location createNewLocation(Location location);

	List<Location> getAllLocations();

	Location findLocationById(int id);

	void updateLocation(Location location);

	void deleteLocation(int id);
}
