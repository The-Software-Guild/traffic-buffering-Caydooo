package com.trackfic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackfic.model.Witness;
import com.trackfic.service.WitnessServiceImpl;

@RestController
@RequestMapping("/witness")
@CrossOrigin
public class WitnessController {

	@Autowired
	WitnessServiceImpl witnessService;

//	@Autowired
//	AccidentServiceImpl accidentService;

//	Currently unimplemented in front end so hiding end point	
//	
//	@GetMapping("/witnesses")
//	public List<Witness> getAllWitnesses() {
//
//		List<Witness> witness = witnessService.getAllWitnesses();
//		return witness;
//	}

	@GetMapping("/{email}")
	public Witness getWitnessById(@PathVariable String email) {
		Witness witness = witnessService.getWitnessByEmail(email.toLowerCase());
		return witness;
	}

	@PostMapping("/add")
	public Witness addWitness(@RequestBody Witness witness) {
		witness.setEmail(witness.getEmail().toLowerCase());
		Witness witness1 = witnessService.addNewWitness(witness);
		return witness1;
	}

//	@PostMapping("/login")
//	public RedirectView  loginWitness(@RequestBody Witness witness, RedirectAttributes redirectAttrs)
//	{
//		Witness witness1 = witnessService.loginWitness(witness.getEmail(), witness.getPassword());
//		
//		redirectAttrs.addFlashAttribute("witness", witness1);
//		List<Accident> accidents = accidentService.getAccidentsByWitnessEmail(witness1.getEmail());
//		redirectAttrs.addFlashAttribute("accidents", accidents);
//		
//		return new RedirectView ("/thyme");
//	}

	@PostMapping("/login")
	public Witness loginWitness(@RequestBody Witness witness) {
		Witness witness1 = witnessService.loginWitness(witness.getEmail().toLowerCase(), witness.getPassword());
		return witness1;
	}

	@PutMapping("{email}")
	public Witness updateWitness(@PathVariable String email, @RequestBody Witness witness) {
		witness.setEmail(witness.getEmail().toLowerCase());
		Witness witness1 = witnessService.updateWitnessData(email.toLowerCase(), witness);
		return witness1;

	}

	@DeleteMapping("/{email}")
	public void deleteWitness(@PathVariable String email) {
		witnessService.deleteWitness(email.toLowerCase());

	}

}
