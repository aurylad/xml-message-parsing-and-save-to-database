package com.auryla.task.service;

import java.util.ArrayList;
import java.util.List;

import static com.auryla.task.service.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auryla.task.jpa.entity.AddressEntity;
import com.auryla.task.jpa.entity.CustomerEntity;
import com.auryla.task.jpa.entity.InvoiceEntity;
import com.auryla.task.jpa.entity.ItemEntity;
import com.auryla.task.repository.AddressRepository;
import com.auryla.task.repository.CustomerRepository;
import com.auryla.task.repository.InvoiceRepository;
import com.auryla.task.repository.ItemRepository;
import com.auryla.task.xml.parser.objects.Address;
import com.auryla.task.xml.parser.objects.Invoice;
import com.auryla.task.xml.parser.objects.Item;
import com.auryla.task.xml.parser.objects.Message;

@Service
public class MessageService {

	private InvoiceEntity invoiceEntity;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerReposittory;

	@Autowired
	private AddressRepository addressRepository;

	public ResponseEntity<Object> messageProcessing(Message message) {

		if (approveHeaderInfo(message)) {
			saveMessage(message);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().body("The message header is invalid");
	}

	private boolean approveHeaderInfo(Message message) {
		if (message.getHeader().getTo().equals(MESSAGE_RECEIVER)
				&& message.getHeader().getFrom().equals(APPROVED_SENDER)) {
			return true;
		}
		return false;
	}

	private void saveMessage(Message message) {
		invoiceEntity = toInvoice(message);
		invoiceRepository.save(invoiceEntity);
		itemRepository.saveAll(toItems(message));
	}

	private InvoiceEntity toInvoice(Message message) {
		Invoice src = message.getBody().getInvoice();

		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setInvoiceNumber(src.getNumber());
		invoice.setDate(src.getDate());
		invoice.setCustomer(toCustomer(message));

		return invoice;
	}

	private CustomerEntity toCustomer(Message message) {
		Address src = message.getBody().getInvoice().getAddress();

		final CustomerEntity customer = customerReposittory.findOneOrCreateByNameAndSurname(src.getName(),
				src.getSurname());
		customer.setAddress(toAddress(message));

		return customer;
	}

	private AddressEntity toAddress(Message message) {
		Address src = message.getBody().getInvoice().getAddress();
		AddressEntity addressTemp = new AddressEntity();
		addressTemp.setCity(src.getCity());
		addressTemp.setCountry(src.getCountry());
		addressTemp.setState(src.getState());
		addressTemp.setStreet(src.getStreet());
		addressTemp.setZip(src.getZip());

		final AddressEntity address = addressRepository.findOneOrCreateByStreetAndCity(addressTemp);

		return address;
	}

	private List<ItemEntity> toItems(Message message) {
		List<Item> itemsList = message.getBody().getInvoice().getItems();
		List<ItemEntity> items = new ArrayList<>();

		for (Item src : itemsList) {
			ItemEntity item = new ItemEntity();
			item.setInvoice(this.invoiceEntity);
			item.setItemName(src.getName());
			item.setItemNumber(src.getNumber());
			item.setQuantity(src.getQuantity());
			item.setUSPrice(src.getUSPrice());

			items.add(item);
		}

		return items;
	}

}
