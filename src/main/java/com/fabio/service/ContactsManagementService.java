package com.fabio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.data.repos.CustomerContactRepository;
import com.fabio.domain.CustomerContact;

@Service
public class ContactsManagementService {

	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		
		CustomerContact newContact = null;
		
		if (aContact.getFirstName() != null) {
			newContact =  customerContactRepository.save(aContact);
		}
		
		return newContact;	
	}

	public Iterable<CustomerContact> findAll() {
		return customerContactRepository.findAll();
		
	}

	public CustomerContact findOne(Long id) {
		return customerContactRepository.findOne(id);
	}
	
	
}
