package com.fabio.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fabio.domain.CustomerContact;
import com.fabio.service.ContactsManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.status.Status;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactsManagementService service;
	
	@InjectMocks
	private ContactsManagementController controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddContact() throws Exception {
		CustomerContact mockcontact = new CustomerContact();
		mockcontact.setFirstName("fabio");
		
		when(service.add(any(CustomerContact.class)))
		.thenReturn(mockcontact);
		
		CustomerContact acontact = new CustomerContact();
		acontact.setFirstName("fabio");
		acontact.setEmail("fabio@fabio.com");
		
		 ObjectMapper objectMapper = new ObjectMapper();
	     String contactjson = objectMapper.writeValueAsString(acontact);
		mockMvc.perform(post("/contacts/add")
		.accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(contactjson))
		.andExpect(status().isOk()).andReturn();
		
	}
	
	@Test
	public void testGetContact() throws Exception {
		CustomerContact mockcontact = new CustomerContact();
		mockcontact.setFirstName("fabio");
		
		when(service.findOne(1L))
		.thenReturn(mockcontact);
		
		
		mockMvc.perform(get("/contacts/1", 1L)
		.accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.firstName").value("fabio"));
		
	}
	

}
