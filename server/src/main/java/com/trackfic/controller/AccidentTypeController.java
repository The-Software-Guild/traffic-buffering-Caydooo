package com.trackfic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackfic.model.AccidentType;
import com.trackfic.service.AccidentTypeServiceImpl;

@RestController
@RequestMapping("/accidenttype")
@CrossOrigin
public class AccidentTypeController {

	@Autowired
	AccidentTypeServiceImpl accidentTypeService;

	// USED
	@GetMapping("/accidenttypes")
	public List<AccidentType> getAllAccidentTypes() {

		List<AccidentType> accidentTypes = accidentTypeService.getAllAccidentTypes();
		return accidentTypes;
	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@GetMapping("/{id}")
//	public AccidentType getAccidentTypeById(@PathVariable int id)
//	{
//		AccidentType accidentType = accidentTypeService.getAccidentTypeById(id);
//		return accidentType;
//	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@PostMapping("/add")
//	public AccidentType addAccidentType(@RequestBody AccidentType accidentType)
//	{
//		AccidentType accidentType1 = accidentTypeService.addNewAccidentType(accidentType);
//		return accidentType1;
//	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@PutMapping("{id}")
//	public AccidentType updateAccidentType(@PathVariable int id, @RequestBody AccidentType accidentType)
//	{
//		AccidentType accidentType1 = accidentTypeService.updateAccidentTypeData(id, accidentType);
//		return accidentType1;
//		
//	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@DeleteMapping("/{id}")
//	public void deleteAccidentType(@PathVariable int id)
//	{
//		accidentTypeService.deleteAccidentType(id);
//		
//	}
}
