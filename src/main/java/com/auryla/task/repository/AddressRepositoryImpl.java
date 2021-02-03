package com.auryla.task.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.auryla.task.jpa.entity.AddressEntity;

@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {

	private final AddressRepository addressRepository;
	
	@Autowired
	public AddressRepositoryImpl(@Lazy AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@Override
	public AddressEntity findOneOrCreateByStreetAndCity(AddressEntity addr) {
		AddressEntity address = addressRepository.findOneByStreetAndCity(addr.getStreet(), addr.getCity());
		if (address == null) {
			address = new AddressEntity();
			address.setCity(addr.getCity());
			address.setCountry(addr.getCountry());
			address.setState(addr.getState());
			address.setStreet(addr.getStreet());
			address.setZip(addr.getZip());
			address = addressRepository.save(address);
		}
		
		return address;
	}

}
