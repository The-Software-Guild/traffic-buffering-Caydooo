package com.trackfic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.trackfic.model.Location;

public class LocationMapper implements RowMapper<Location> {

	@Override
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {

		int locationId = rs.getInt("location_id");
		String streetNumber = rs.getString("street_number");
		String streetName = rs.getString("street_name");
		String suburb = rs.getString("suburb");
		int postcode = rs.getInt("postcode");
		String state = rs.getString("loc_state");
		double latitude = rs.getDouble("latitude");
		double longitude = rs.getDouble("longitude");

		Location location = new Location(locationId, streetName, streetNumber, suburb, postcode, state, latitude,
				longitude);

		return location;
	}

}
