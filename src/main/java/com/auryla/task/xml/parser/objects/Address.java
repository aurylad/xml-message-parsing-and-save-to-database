package com.auryla.task.xml.parser.objects;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;

@Data
public class Address {

	private String country;
	
	private String name;
	
	private String surname;

	private String street;

	private String city;

	private String state;

	private int zip;

	@XmlAttribute
	public void setCountry(String country) {
		this.country = country;
	}
}
