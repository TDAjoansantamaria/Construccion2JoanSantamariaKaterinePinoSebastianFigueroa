package app.dao;

import app.dto.InvoiceDto;

public interface InvoiceDao {

	public void createInvoice(InvoiceDto invoiceDto) throws Exception;

}
