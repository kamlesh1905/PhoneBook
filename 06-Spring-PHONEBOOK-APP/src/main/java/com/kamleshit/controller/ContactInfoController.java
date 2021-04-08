package com.kamleshit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kamleshit.Service.ContactService;
import com.kamleshit.constant.AppConstant;
import com.kamleshit.entity.Contact;
import com.kamleshit.props.AppProperties;

@Controller
public class ContactInfoController {

private ContactService service;
	
	private AppProperties props;
	
	public ContactInfoController(ContactService service,AppProperties props) 
	  {
		  this.service = service;
		  this.props=props;
		  
	  }
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) 
	{
		Contact contactById = service.getContactById(contactId);
		
		model.addAttribute(AppConstant.CONTACT, contactById);
		
		return AppConstant.CONTACT;

	}

	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId,RedirectAttributes rd)
	{
		
		
		boolean isDeleted = service.deleteContactById(contactId);
		
		Map<String, String> messages = props.getMessages();
		
		if(isDeleted)
		{
			rd.addFlashAttribute("sussMsg", messages.get("DeleteSucc"));
		}
		else
		{
			rd.addFlashAttribute("failMsg", messages.get("DeleteFail"));
		}
		return "redirect:view-contacts";
	}
	
	
}
