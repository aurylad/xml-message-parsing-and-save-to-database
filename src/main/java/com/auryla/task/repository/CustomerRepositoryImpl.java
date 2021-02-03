package com.auryla.task.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.auryla.task.jpa.entity.CustomerEntity;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerRepositoryImpl(@Lazy CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public CustomerEntity findOneOrCreateByNameAndSurname(String name, String surname) {
		CustomerEntity customer = customerRepository.findOneByNameAndSurname(name, surname);
		if (customer == null) {
			customer = new CustomerEntity();
			customer.setName(name);
			customer.setSurname(surname);
			customer = customerRepository.save(customer);
		}
		
		return customer;
	}

}
