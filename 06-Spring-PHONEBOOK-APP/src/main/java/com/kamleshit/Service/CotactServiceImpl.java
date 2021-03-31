package com.kamleshit.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kamleshit.entity.Contact;
import com.kamleshit.repository.ContactRepository;

@Service
public class CotactServiceImpl implements ContactService {
	
	
	private ContactRepository repository;

	public CotactServiceImpl(ContactRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean saveOrUpdate(Contact contact) 
	{
		Contact savedObj = repository.save(contact);
		
		/*
		 * if(savedObj.getContactId()!=null) { return true; } else { return false; }
		 */
		
		// return (savedObj.getContactId()!=null )? true : false;	
		
		return savedObj.getContactId() != null; //if condition satisfy then true or false
		
	}

	@Override
	public List<Contact> getAllContact() {
	
		/*
		 * List<Contact> findAll = repository.findAll(); return findAll;
		 */
		
		return repository.findAll();
		
	}

	@Override
	public Contact getContactById(Integer contactId) 
	{
		Optional<Contact> findById = repository.findById(contactId);
		
		if(findById.isPresent())
		{
			//Contact contact = findById.get();
			//return contact;
			
			return findById.get();	
		}
		
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) 
	{
		boolean isDeleted = false;
		try 
		{
		  repository.deleteById(contactId);
		  isDeleted = true;
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isDeleted;
	}

}
