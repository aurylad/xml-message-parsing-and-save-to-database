package com.auryla.task.repository;

import com.auryla.task.jpa.entity.AddressEntity;

public interface AddressRepositoryCustom {
	
	AddressEntity findOneOrCreateByStreetAndCity(AddressEntity address);

}
