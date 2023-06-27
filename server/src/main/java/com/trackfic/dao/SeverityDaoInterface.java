package com.trackfic.dao;

import java.util.List;

import com.trackfic.enums.AccidentSeverity;

public interface SeverityDaoInterface {

	AccidentSeverity findSeverityByValue(String value);

	List<AccidentSeverity> getAllSeverities();

}
