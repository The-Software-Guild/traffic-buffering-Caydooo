package com.trackfic.service;

import java.util.List;

import com.trackfic.enums.AccidentSeverity;

public interface SeverityServiceInterface {

	AccidentSeverity getSeverityByValue(String value);

	List<AccidentSeverity> getAllSeverities();

}
