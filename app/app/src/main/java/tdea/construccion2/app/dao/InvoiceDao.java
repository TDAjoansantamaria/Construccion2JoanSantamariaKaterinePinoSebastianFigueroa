package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.InvoiceDto;

public interface InvoiceDao {

	public void createInvoice(InvoiceDto invoiceDto) throws Exception;

}
