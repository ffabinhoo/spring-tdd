package com.fabio.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.fabio.domain.CustomerContact;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {
	
	@Autowired
	private ContactsManagementService contactsManagementService;
	
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("fabio");
		aContact.setLastName("costa");
		
		
		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		
		// Verify the addition
		assertNotNull(newContact);
		assertNotNull(newContact.getId());
		assertEquals("fabio", newContact.getFirstName());
		
	}
}
