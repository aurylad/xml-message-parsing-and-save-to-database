package com.auryla.task.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.auryla.task.jpa.entity.ItemEntity;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity, Long> {
	
}
