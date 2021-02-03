package com.auryla.task.xml.parser.objects;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.Data;

@Data
public class Item implements Comparable<Item>{
	
	private int number;
	
	private String name;
	
	private int quantity;
	
	private BigDecimal USPrice;

	@XmlAttribute
	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(Item o) {
		return o.USPrice.doubleValue() > this.USPrice.doubleValue() ? 1 : -1;
	}
	
	
}
