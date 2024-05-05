package tdea.construccion2.app.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@ManyToOne
	@JoinColumn(name = "idpet")
	private Pet idPet;
	@ManyToOne
	@JoinColumn(name = "idowner")
	private Person idOwner;
	@Column(name = "productname")
	private String productName;
	@Column(name = "value")
	private double value;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "invoicedate")
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
