package com.fabio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.fabio.controller.ContactsManagementControllerIntegrationTest;
import com.fabio.data.repos.CustomerContactRepositoryIntegrationTest;
import com.fabio.service.ContactsManagementServiceIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ContactsManagementServiceIntegrationTest.class, ContactsManagementControllerIntegrationTest.class, CustomerContactRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
