package com.trackfic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trackfic.dao.SeverityDaoInterface;
import com.trackfic.enums.AccidentSeverity;

@Service
public class SeverityServiceImpl implements SeverityServiceInterface {

	SeverityDaoInterface severityDao;

	public SeverityServiceImpl(SeverityDaoInterface severityDao) {
		this.severityDao = severityDao;

	}

	@Override
	public AccidentSeverity getSeverityByValue(String value) {
		return severityDao.findSeverityByValue(value);
	}

	@Override
	public List<AccidentSeverity> getAllSeverities() {
		// TODO Auto-generated method stub
		return severityDao.getAllSeverities();
	}

}
