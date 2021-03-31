package com.kamleshit.Service;

import java.util.List;

import com.kamleshit.entity.Contact;

public interface ContactService 
{
	public boolean saveOrUpdate(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer contactId);
	
	public boolean deleteContactById(Integer contactId);
	
	

}
