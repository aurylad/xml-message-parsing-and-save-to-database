package com.auryla.task.jpa.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
abstract class AbstractBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id_", unique = true, nullable = false)
	private final Long id;

	AbstractBaseEntity(Long id) {
		this.id = id;
	}

	AbstractBaseEntity() {
		this.id = null;
	}

	public Long getId() {
		return id;
	}

}
