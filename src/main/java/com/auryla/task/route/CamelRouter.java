package com.auryla.task.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {
	
	/*
	 * It was not enough time to me, to complete second part of homework task
	 * */

	@Override
	public void configure() throws Exception {
		
		from("activemq:my-activemq-queue")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				
//				Queue<Message> customerOrders = new PriorityQueue<>();

			}
		})
		.to("log:received-message-from-active-mq");

	}

}
 