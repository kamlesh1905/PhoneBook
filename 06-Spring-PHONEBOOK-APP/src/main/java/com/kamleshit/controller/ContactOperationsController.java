package com.kamleshit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kamleshit.entity.Contact;

@Controller
public class ContactOperationsController 
{
	
	@GetMapping("/loadform")
	public String loadForm(Model model)
	{
		Contact cobj = new Contact();
		
		model.addAttribute("contact", cobj);
		
		return "contact";
	}
	

	public String handleSubmitBtn1()
	{
		return "contact";
	}
	

	public String handleViewsContactHyperlink()
	{
		return "contact";
	}
	
	
	
	
	
	

}
