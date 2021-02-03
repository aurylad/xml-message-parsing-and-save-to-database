package com.auryla.task.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.auryla.task.jpa.entity.AddressEntity;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<AddressEntity, Long>, AddressRepositoryCustom {

	AddressEntity findOneByStreetAndCity(@Param("street") String street, @Param("city") String city);
}
