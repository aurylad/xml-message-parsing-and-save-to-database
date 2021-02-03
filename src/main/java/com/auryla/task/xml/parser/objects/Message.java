package com.auryla.task.xml.parser.objects;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Message {

	private Header header;
	
	private Body body;
}
