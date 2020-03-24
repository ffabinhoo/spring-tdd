package com.fabio.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.fabio.domain.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

	public CustomerContact findByEmail(String email);
}
