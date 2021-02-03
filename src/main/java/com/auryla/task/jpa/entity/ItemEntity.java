package com.auryla.task.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "items", uniqueConstraints = @UniqueConstraint(columnNames = { "item_number" }))
public class ItemEntity extends AbstractBaseEntity {
	
	@Column(name = "item_number", nullable = false)
	private int itemNumber;

	@Column(name = "item_name", nullable = false)
	private String itemName;

	@Column(nullable = false)
	private int quantity;

	@Column(name = "us_price", nullable = false)
	private BigDecimal USPrice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	private InvoiceEntity invoice;
	
	public ItemEntity(Long id) {
		super(id);
	}
}
