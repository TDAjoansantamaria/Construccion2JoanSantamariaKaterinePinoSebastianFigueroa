package tdea.construccion2.app.service;

import tdea.construccion2.app.dto.InvoiceDto;

public interface SellerService {
	public void createInvoice(InvoiceDto invoiceDto) throws Exception;

	public void searchInvoice(InvoiceDto invoiceDto) throws Exception;
}
