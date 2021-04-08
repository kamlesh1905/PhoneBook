package com.kamleshit.controller;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kamleshit.Service.ContactService;
import com.kamleshit.constant.AppConstant;
import com.kamleshit.entity.Contact;
import com.kamleshit.props.AppProperties;

@Controller
public class ContactOperationsController 
{
	
	private ContactService service;
	
	private AppProperties props;
	
	public ContactOperationsController(ContactService service,AppProperties props) 
	  {
		  this.service = service;
		  this.props=props;
		  
	  }
	 

	 @GetMapping("/loadform")
	
	public String loadForm(Model model)
	{
		Contact cobj = new Contact();
		
		model.addAttribute(AppConstant.CONTACT, cobj);
		
		return AppConstant.CONTACT;
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(Contact contact,Model model)
	{
		System.out.println("Contact : " + contact);
		
		Integer contactId = contact.getContactId();
		
		boolean isSaved = service.saveOrUpdate(contact);
		
		Map<String, String> messages = props.getMessages();
		
		if(isSaved)
		{
			if(contactId==null)
			{
				model.addAttribute("succMsg", messages.get("contactSaved"));
			}
			else
			{
				model.addAttribute("succMsg", messages.get("contactUpdateSucc"));
			}
			
			model.addAttribute("succMsg", messages.get("contactSaved"));
			//System.out.println("succMsg");
		}
		else
		{
			model.addAttribute("failMsg", messages.get("contactSaveFail"));
		}
		
		return "contact";
	}
	

	@GetMapping("/view-contacts")
	public String handleViewsContactHyperlink(Model model)
	{
		List<Contact> allContact = service.getAllContact();	
		
		model.addAttribute(AppConstant.CONTACT, allContact);
		
		return "contacts-display";
	}
	

	
}
