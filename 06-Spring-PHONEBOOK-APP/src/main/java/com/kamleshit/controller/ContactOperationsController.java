package com.kamleshit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kamleshit.Service.ContactService;
import com.kamleshit.entity.Contact;

@Controller
public class ContactOperationsController 
{
	
	private ContactService service;
	
	public ContactOperationsController(ContactService service) 
	  {
		  this.service = service;
		  
	  }
	 
	
	@RequestMapping("/hello")
	public String Hello(Model model)
	{
		
		model.addAttribute("message","Hello JSP");
		return "contact";
	}
	

	 @GetMapping("/loadform")
	
	public String loadForm(Model model)
	{
		Contact cobj = new Contact();
		
		model.addAttribute("contact", cobj);
		
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(Contact contact,Model model)
	{
		//System.out.println("Contact : " + contact);
		
		boolean isSaved = service.saveOrUpdate(contact);
		
		if(isSaved)
		{
			model.addAttribute("succMsg","Contact saved");
		}
		else
		{
			model.addAttribute("failMsg","Failed to saved");
		}
		
		return "contact";
	}
	

	public String handleViewsContactHyperlink()
	{
		
		return "contact";
	}
	

	
}
