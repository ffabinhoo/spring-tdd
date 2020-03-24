package com.fabio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.fabio.controller.ContactsManagementControllerIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ DatastoreSystemsHealthTest.class, 
	ContactsManagementControllerIntegrationTest.class })

public class ContinuousIntegrationTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
