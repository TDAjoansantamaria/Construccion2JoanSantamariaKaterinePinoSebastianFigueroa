package app.controller;

import java.util.Scanner;

import app.controller.VetController;
import app.dto.InvoiceDto;
import app.validators.MedicalHistoryInputsValidator;
import app.dto.MedicalHistoryDto;
import app.service.VetService;
import app.service.VeterinarianService;

public class SellerController {
	private static Scanner reader = new Scanner(System.in);
	private static MedicalHistoryInputsValidator medicalHistoryInputsValidator = new MedicalHistoryInputsValidator();
	private static VetService vetService = new VeterinarianService();

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
}
