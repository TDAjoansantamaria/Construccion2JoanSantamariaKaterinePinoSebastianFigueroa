package tdea.construccion2.app.dto;

import java.sql.Date;

public class InvoiceDto {
	private long idOrder;
	private double valueInvoice;
	private int quantity;
	private Date invoiceDate;

	public InvoiceDto(long idOrder, double valueInvoice, int quantity) {
		super();
		this.idOrder = idOrder;
		this.valueInvoice = valueInvoice;
		this.quantity = quantity;
	}

	public InvoiceDto(long idOrder) {
		super();
		this.idOrder = idOrder;
	}

	public long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	public double getValueInvoice() {
		return valueInvoice;
	}

	public void setValueInvoice(double valueInvoice) {
		this.valueInvoice = valueInvoice;
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
