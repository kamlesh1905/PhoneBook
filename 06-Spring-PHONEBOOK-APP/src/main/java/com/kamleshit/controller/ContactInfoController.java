package com.kamleshit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kamleshit.Service.ContactService;
import com.kamleshit.entity.Contact;

@Controller
public class ContactInfoController {

	private ContactService service;

	public ContactInfoController(ContactService service) 
	  {
		  this.service = service;
		  
	  }

	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) 
	{
		Contact contactById = service.getContactById(contactId);
		
		model.addAttribute("contact", contactById);
		
		return "contact";

	}

	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId,Model model)
	{
		boolean isDeleted = service.deleteContactById(contactId);
		if(isDeleted)
		{
			model.addAttribute("sussMsg", "Contact Deleted Successfully");
		}
		else
		{
			model.addAttribute("failMsg", "Failed to delete");
		}
		return "redirect:view-contacts";
	}
	
	
}
