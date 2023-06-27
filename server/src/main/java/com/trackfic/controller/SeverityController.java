package com.trackfic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackfic.enums.AccidentSeverity;
import com.trackfic.service.SeverityServiceImpl;

@RestController
@RequestMapping("/severity")
@CrossOrigin
public class SeverityController {

	@Autowired
	SeverityServiceImpl severityService;

	@GetMapping("/{value}")
	public AccidentSeverity getAccidentSeverityByValue(@PathVariable String value) {
		AccidentSeverity severity = severityService.getSeverityByValue(value);
		return severity;
	}

	@GetMapping("/severities")
	public List<AccidentSeverity> getAllSeverities() {

		List<AccidentSeverity> severities = severityService.getAllSeverities();
		return severities;
	}

}
