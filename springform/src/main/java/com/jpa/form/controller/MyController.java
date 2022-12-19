package com.jpa.form.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.form.entities.LoginData;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openform(Model model) {
		model.addAttribute("loginData",new LoginData());
		return "form";
	}
	//handler for process form
	@PostMapping("/submit")
	public String processform(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "form";
		}
		
		return "success";
	}
	

}
