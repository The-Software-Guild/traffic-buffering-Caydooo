package com.trackfic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.trackfic.model.Witness;

public class WitnessMapper implements RowMapper<Witness> {

	@Override
	public Witness mapRow(ResultSet rs, int rowNum) throws SQLException {

		String email = rs.getString("witness_email");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		int mobile = rs.getInt("mobile");
		String password = rs.getString("password");

		Witness witness = new Witness(email, firstName, lastName, mobile, password);

		return witness;
	}

}
