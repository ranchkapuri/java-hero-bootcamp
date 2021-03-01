package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	
	@GetMapping("")
	public String getRootWebpage (ModelMap model) {
		//   This is what gets returned / resolved when we
		//     return a String inside of a regular Controller GetMapping method
		//   /src/main/resources/templates/welcome.html
		String firstName = "Ervis";
		String lastName = "Todi";
		model.put("firstName", firstName);
		model.put("lastName", lastName);
		
		return "welcome";
	}

}
