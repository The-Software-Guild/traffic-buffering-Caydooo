package com.trackfic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

//	@GetMapping(value = "/thyme")
//	public String getTemplate(RedirectAttributes redirectAttrs) {
//		System.out.println("Inside getTemplate");
//
//		Witness w = (Witness) redirectAttrs.getAttribute("witness");
//		return "thymetemplate";
//	}

//	@GetMapping(value = "/login")
//	public String loginUser(ModelMap model, @ModelAttribute("witness") Object witness, @ModelAttribute("accidents") List<Accident> accidents) {
//
//		Witness w = (Witness) witness;
//		model.addAttribute("witness" , witness);
//		model.addAttribute("accidents" , accidents);
//		return "login";
//	}

	@GetMapping(value = "/home")
	public String goHome() {
		return "trackfic";
	}

}
