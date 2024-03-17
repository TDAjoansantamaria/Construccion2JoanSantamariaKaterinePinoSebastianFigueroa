package app.service;

import app.dto.PetDto;
import app.dto.InvoiceDto;
import app.dto.MedicalHistoryDto;

public interface VetService {
	public void createPet(PetDto petDto) throws Exception;

	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void createInvoice(InvoiceDto invoiceDto) throws Exception;
}
