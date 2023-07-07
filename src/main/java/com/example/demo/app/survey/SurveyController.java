package com.example.demo.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Survey Form");
		return "survey/form";
	}
}
