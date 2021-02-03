package com.auryla.task.repository;

import org.springframework.data.repository.query.Param;

import com.auryla.task.jpa.entity.CustomerEntity;

public interface CustomerRepositoryCustom {

	CustomerEntity findOneOrCreateByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
