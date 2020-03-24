package com.fabio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.domain.CustomerContact;
import com.fabio.service.ContactsManagementService;

@RestController
@RequestMapping("/contacts")
public class ContactsManagementController {

	@Autowired
	private ContactsManagementService contactsManagementService;
	
	@GetMapping
	public Iterable<CustomerContact> findAllContact() {
		return contactsManagementService.findAll();
	}
	
	@GetMapping(path="/{id}")
	public CustomerContact findOneContact(@PathVariable("id") Long id) {
		return contactsManagementService.findOne(id);
	}
	
	
	@RequestMapping(path = "/add", method=RequestMethod.POST)
	public String processAddContactSubmit(@RequestBody CustomerContact aContact) {
		
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		if (newContact != null) {
			return "success";
		}
		
		return "failure";
	}
}
