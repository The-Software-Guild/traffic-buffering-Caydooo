package com.trackfic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackfic.model.Accident;
import com.trackfic.service.AccidentServiceImpl;

@RestController
@RequestMapping("/accident")
@CrossOrigin
public class AccidentController {

	@Autowired
	AccidentServiceImpl accidentService;

	// USED
	@GetMapping("/accidents")
	public List<Accident> getAllAccidents() {

		List<Accident> accidents = accidentService.getAllAccidents();
		return accidents;
	}

	// USED
	@GetMapping("/bywitnessemail/{email}")
	public List<Accident> getAccidentsByWitnessEmail(@PathVariable String email) {
		return accidentService.getAccidentsByWitnessEmail(email);

	}
//	Currently unimplemented in front end so hiding end point	
//	
//	@GetMapping("/{id}")
//	public Accident getAccidentById(@PathVariable int id)
//	{
//		Accident accident = accidentService.getAccidentById(id);
//		
//		return accident;
//	}

	// USED
	@PostMapping("/add")
	public Accident addAccident(@Valid @RequestBody Accident accident) {
		Accident accident1 = accidentService.addNewAccident(accident);
		return accident1;
	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@PutMapping("{id}")
//	public Accident updateAccident(@PathVariable int id, @RequestBody Accident accident)
//	{
//		Accident accident1 = accidentService.updateAccidentData(id, accident);
//		return accident1;
//		
//	}

	@DeleteMapping("/{id}")
	public void deleteAccident(@PathVariable int id) {
		accidentService.deleteAccident(id);

	}

}
