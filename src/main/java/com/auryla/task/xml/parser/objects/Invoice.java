package com.auryla.task.xml.parser.objects;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.Data;

@Data
public class Invoice {
	
	private int number;
	
	private Date date;

	private Address address;
	
	private List<Item> items;
	
	@XmlAttribute
	public void setNumber(int number) {
		this.number = number;
	}

	@XmlAttribute
	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public List<Item> getItems() {
		return items;
	}
}
