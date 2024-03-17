package app.models;

import java.sql.Date;

public class Invoice {

	private long id;
	private Pet idPet;
	private Person idOwner;
	// private Order idOrder;
	private String productName;
	private double value;
	private int quantity;
	private Date invoiceDate;

	public Invoice() {
		this.invoiceDate = new Date(System.currentTimeMillis());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pet getIdPet() {
		return idPet;
	}

	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}

	public Person getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Person idOwner) {
		this.idOwner = idOwner;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/*
	 * public Order getIdOrder() { return idOrder; } public void setIdOrder(Order
	 * idOrder) { this.idOrder = idOrder; }
	 */

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
