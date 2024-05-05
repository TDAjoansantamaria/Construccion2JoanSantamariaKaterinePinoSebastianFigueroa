package tdea.construccion2.app.service;

import tdea.construccion2.app.dto.InvoiceDto;
import tdea.construccion2.app.dto.MedicalHistoryDto;
import tdea.construccion2.app.dto.PetDto;

public interface VetService {
	public void createPet(PetDto petDto) throws Exception;

	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void createInvoice(InvoiceDto invoiceDto) throws Exception;
	
	//public void searchHistory(PetDto petDto) throws Exception;

	//public void viewHistory(PetDto petDto) throws Exception;
}
