package app.service;

import app.dto.InvoiceDto;

public interface SellerService {
	public void createInvoice(InvoiceDto invoiceDto) throws Exception;

	public void searchInvoice(InvoiceDto invoiceDto) throws Exception;
}
