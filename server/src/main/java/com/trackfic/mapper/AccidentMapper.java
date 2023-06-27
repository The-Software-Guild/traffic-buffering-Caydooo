package com.trackfic.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.jdbc.core.RowMapper;

import com.trackfic.enums.AccidentSeverity;
import com.trackfic.model.Accident;

public class AccidentMapper implements RowMapper<Accident> {

	@Override
	public Accident mapRow(ResultSet rs, int rowNum) throws SQLException {

		int accidentId = rs.getInt("accident_id");
		int vehicleCount = rs.getInt("vehicle_count");
		Date accidentDate = rs.getDate("accident_date");
		Time accidentTime = rs.getTime("accident_time");
		String accidentDesc = rs.getString("accident_desc");
		int locationId = rs.getInt("location_id");
		int typeId = rs.getInt("accident_type_id");
		String witnessEmail = rs.getString("witness_email");
		AccidentSeverity severity = AccidentSeverity.valueOf(rs.getString("severity"));

		if (severity.equals("null")) {

		}

		Accident accident = new Accident(accidentId, vehicleCount, accidentTime, accidentDate, accidentDesc, locationId,
				typeId, witnessEmail, severity);

		return accident;
	}

}
