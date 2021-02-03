package com.auryla.task.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auryla.task.jpa.entity.CustomerEntity;

@Repository
public interface CustomerRepository
		extends PagingAndSortingRepository<CustomerEntity, Long>, CustomerRepositoryCustom {

	CustomerEntity findOneByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
