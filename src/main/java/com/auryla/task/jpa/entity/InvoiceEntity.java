package com.auryla.task.jpa.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "invoices", uniqueConstraints = @UniqueConstraint(columnNames = { "invoice_number" }))
public class InvoiceEntity extends AbstractBaseEntity {

	@Column(name = "invoice_number", nullable = false)
	private int invoiceNumber;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	public InvoiceEntity(Long id) {
		super(id);
	}
}
