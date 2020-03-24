package com.fabio.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import com.fabio.data.repos.CustomerContactRepository;
import com.fabio.domain.CustomerContact;
import com.fabio.service.ContactsManagementService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {
	
	@Mock
	private CustomerContactRepository customerContactRepository;
	
	@InjectMocks
	private ContactsManagementService contactsManagementService;
	
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aMockContact = new CustomerContact();
		aMockContact.setFirstName("fabio");
		aMockContact.setLastName("costa");
		
		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);
				
		// Save the contact
		CustomerContact newContact = contactsManagementService.add(aMockContact);
		
		
		// Verify the save
		assertEquals("fabio", newContact.getFirstName());
	}
}
