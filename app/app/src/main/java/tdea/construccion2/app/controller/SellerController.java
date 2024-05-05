package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.InvoiceDto;
import tdea.construccion2.app.service.VetService;
import tdea.construccion2.app.validators.MedicalHistoryInputsValidator;
@Component
public class SellerController {
	
	@Autowired
	private  MedicalHistoryInputsValidator medicalHistoryInputsValidator;
	@Autowired
	private  VetService vetService;
	private static Scanner reader = new Scanner(System.in);
	private static final String MENU = "-------------------------------\n" + "           Menu                \n"
			+ "-------------------------------\n" + "1.Vender medicamentos \n" + "2.Consultar orden medica \n"
			+ "3.Para cerrar sesion \n" + "-------------------------------\n";

	VetController vetController = new VetController();

	private void createInvoice() throws Exception {

		System.out.println("-------------------------------\n" + "Ingrese la orden a facturar");
		long idOrden = medicalHistoryInputsValidator.idOrderValidator(reader.nextLine());
		InvoiceDto invoiceDto = new InvoiceDto(idOrden);
		vetService.createInvoice(invoiceDto);

	}

	private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			createInvoice();
			return true;
		}

		case "2": {
			vetController.viewOrder();
			return true;
		}
		case "3": {

			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

	public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(MENU);
				String option = reader.nextLine();
				runApp = menu(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public MedicalHistoryInputsValidator getMedicalHistoryInputsValidator() {
		return medicalHistoryInputsValidator;
	}

	public void setMedicalHistoryInputsValidator(MedicalHistoryInputsValidator medicalHistoryInputsValidator) {
		this.medicalHistoryInputsValidator = medicalHistoryInputsValidator;
	}

	public VetService getVetService() {
		return vetService;
	}

	public void setVetService(VetService vetService) {
		this.vetService = vetService;
	}

	public VetController getVetController() {
		return vetController;
	}

	public void setVetController(VetController vetController) {
		this.vetController = vetController;
	}
	
}
