package com.trackfic.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.trackfic.exception.ForeignKeyDeletionException;
import com.trackfic.exception.LocationNotFoundException;
import com.trackfic.mapper.LocationMapper;
import com.trackfic.model.Location;

@Component
public class LocationDaoImpl implements LocationDaoInterface {

	private final JdbcTemplate jdbcTemplate;
	private Location returnedLocation;

	public LocationDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		returnedLocation = new Location();
	}

	@Override
	public Location createNewLocation(Location location) {

		jdbcTemplate.update("ALTER TABLE location AUTO_INCREMENT =1;");
		String sql = "insert into location (street_number, street_name, suburb, postcode, loc_state, latitude, longitude)"
				+ " values(?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, location.getStreetNumber(), location.getStreetName(), location.getSuburb(),
				location.getPostcode(), location.getState(), location.getLatitude(), location.getLongitude());

		sql = "select max(location_id) from location";
		int max = jdbcTemplate.queryForObject(sql, Integer.class);

		location.setLocationId(max);

		return location;
	}

	@Override
	public List<Location> getAllLocations() {

		String sql = "select * from location";

		return jdbcTemplate.query(sql, new LocationMapper());
	}

	@Override
	public Location findLocationById(int id) {

		String sql = "select * from location where location_id=?";
		try {
			returnedLocation = jdbcTemplate.queryForObject(sql, new Object[] { id }, new LocationMapper());
		} catch (Exception ex) {
			throw new LocationNotFoundException("Location with ID: " + id + " not found");
		}

		return returnedLocation;
	}

	@Override
	public void updateLocation(Location location) {

		String sql = "update location set street_number=?,street_name=?,suburb=?,postcode=?,loc_state=?,latitude=?,longitude=? where location_id=?";
		jdbcTemplate.update(sql, location.getStreetNumber(), location.getStreetName(), location.getSuburb(),
				location.getPostcode(), location.getState(), location.getLatitude(), location.getLongitude(),
				location.getLocationId());
	}

	@Override
	public void deleteLocation(int id) {
		try {
			String sql = "delete from location where location_id=?";
			jdbcTemplate.update(sql, new Object[] { id });
		} catch (Exception e) {
			throw new ForeignKeyDeletionException(
					"Foreign key references object to be deleted ensure correct delete order is followed");
		}
	}

}
