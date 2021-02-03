package com.auryla.task.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auryla.task.service.MessageService;
import com.auryla.task.xml.parser.objects.Message;

/* SAMPLE MESSAGE
<?xml version="1.0"?>
<message>
	<header>
		<to>companyReceiver</to>
		<from>companySender</from>
		<type>saveInvoice</type>
	</header>
	<body>
		<invoice date="2021-02-01" number="123">
			<address country="Eu">
				<name>John</name>
                <surname>Smith</surname>
				<street>123 George St.</street>
				<city>Mountain View</city>
				<state>CA</state>
				<zip>94041</zip>
			</address>
			<items>
				<item number="1">
					<name>IBM A20 Laptop</name>
					<quantity>1</quantity>
					<USPrice>2000.00</USPrice>
				</item>
                <item number="2">
					<name>IBM A25 Laptop</name>
					<quantity>1</quantity>
					<USPrice>1500.00</USPrice>
				</item>
			</items>
		</invoice>
	</body>
</message>
*/

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@PostMapping(value = "/message", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Object> handleMessage(@RequestBody Message message) {
		return messageService.messageProcessing(message);
	}
	
}
