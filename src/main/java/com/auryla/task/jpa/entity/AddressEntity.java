package com.auryla.task.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "addresses", uniqueConstraints = 
@UniqueConstraint(columnNames = { "country", "street", "city", "state", "zip" }))
public class AddressEntity extends AbstractBaseEntity {

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private int zip;
}
