package app.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import app.App;
import app.config.MYSQLConnection;
import app.dto.MedicalHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.service.AdminService;
import app.service.VetService;
import app.service.VeterinarianService;
import app.validators.MedicalHistoryInputsValidator;
import app.validators.PersonInputsValidator;
import app.validators.PetInputsValidator;

public class VetController {
	public Connection connection = MYSQLConnection.getConnection();
	private static PetInputsValidator petInputValidator = new PetInputsValidator();
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static MedicalHistoryInputsValidator medicalHistoryInputsValidator = new MedicalHistoryInputsValidator();
	private static VetService vetService = new VeterinarianService();
	private static AdminService adminService = new VeterinarianService();
	private static Scanner reader = new Scanner(System.in);
	private static App app = new App();

	private static final String MENU = "-------------------------------\n" + "           Menu                \n"
			+ "-------------------------------\n" + "1.Crear historia medica \n" + "2.Consultar historia medica \n"
			+ "3.Editar una historia \n" + "4.Listado de ordenes para consulta \n" + "5.Anular orden \n"
			+ "6.Registrar Mascota \n" + "7.Registrar Dueño	\n" + "8.Para cerrar Sesion \n"
			+ "-------------------------------\n";

	private void createPet() throws Exception {
		System.out.println("-------------------------------");
		System.out.println("ingrese la cedula del Dueño");
		long idOwner = petInputValidator.idOwnerValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese el nombre de la mascota");
		String namePet = reader.nextLine();
		petInputValidator.namePetValidator(namePet);
		System.out.println("-------------------------------");
		System.out.println("ingrese la edad de la mascota");
		int age = petInputValidator.ageValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese la Raza");
		String breedPet = reader.nextLine();
		petInputValidator.breedValidator(breedPet);
		System.out.println("-------------------------------");
		System.out.println("ingrese la opcion de especie de la mascota:");
		System.out.println("-------------------------------");
		System.out.println("1. Perro \n" + "2. Gato \n" + "3. Pez \n" + "4. Ave\n");
		System.out.println("-------------------------------");
		String speciePet = reader.nextLine();
		switch (speciePet) {
		case "1": {
			speciePet = "Perro";
			break;
		}
		case "2": {
			speciePet = "Gato";
			break;
		}
		case "3": {
			speciePet = "Pez";
			break;
		}
		case "4": {
			speciePet = "Ave";
			break;
		}
		default: {
			System.out.println("ingrese una opcion valida");
		}
		}

		petInputValidator.speciesValidator(speciePet);

		System.out.println("-------------------------------");
		System.out.println("ingrese las caracteristicas (Color y Tamaño) ");
		String characPet = reader.nextLine();
		petInputValidator.characteristicsValidator(characPet);
		System.out.println("ingrese el Peso ");
		double weightPet = petInputValidator.weightValidator(reader.nextLine());

		PetDto petDto = new PetDto(idOwner, namePet, age, breedPet, speciePet, characPet, weightPet);
		vetService.createPet(petDto);

	}

	private void createOwner() throws Exception {

		System.out.println("-------------------------------");
		System.out.println("ingrese el codigo de la mascota");
		Long id = personInputValidator.idValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese el nombre completo");
		String fullName = reader.nextLine();
		personInputValidator.fullNameValidator(fullName);
		System.out.println("-------------------------------");
		System.out.println("ingrese la edad");
		int age = personInputValidator.ageValidator(reader.nextLine());
		System.out.println("-------------------------------");

		PersonDto personDto = new PersonDto(id, fullName, age, "Propietario", "", "");
		adminService.createOwner(personDto);
	}

	private void createHistory() throws Exception {
		long date = System.currentTimeMillis();
		Date date1 = new Date(date);
		String date2 = date1.toString();
		System.out.println(date2);

		System.out.println("-------------------------------");
		System.out.println("--------HISTORIA MEDICA--------");
		System.out.println("-------------------------------");
		System.out.println("ingrese el codigo de la Mascota");
		long idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese la cedula del Dueño: ");
		long idOwner = petInputValidator.idOwnerValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese razón de la consulta: ");
		String reason = reader.nextLine();
		medicalHistoryInputsValidator.reasonValidator(reason);
		System.out.println("-------------------------------");
		System.out.println("ingrese Sintomatologia: ");
		String symptoms = reader.nextLine();
		medicalHistoryInputsValidator.symptomsValidator(symptoms);
		System.out.println("-------------------------------");
		System.out.println("ingrese Diagnostico");
		String diagnosis = reader.nextLine();
		medicalHistoryInputsValidator.diagnosisValidator(diagnosis);
		System.out.println("-------------------------------");
		System.out.println("ingrese Procedimiento");
		String procedure = reader.nextLine();
		System.out.println("-------------------------------");
		System.out.println("ingrese la vacunacion de la mascota: ");
		String vaccination = reader.nextLine();
		medicalHistoryInputsValidator.procedureValidator(procedure);
		System.out.println("-------------------------------");
		System.out.println("ingrese detalle del Procedimiento: ");
		String procedureDetails = reader.nextLine();
		medicalHistoryInputsValidator.procedureDetailsValidator(procedureDetails);
		System.out.println("-------------------------------");
		System.out.println("ingrese las alergias de la mascota: ");
		String allergy = reader.nextLine();
		System.out.println("-------------------------------");
		System.out.println("ingrese medicamento");
		String medicine = reader.nextLine();
		medicalHistoryInputsValidator.medicineValidator(medicine);
		System.out.println("-------------------------------");
		System.out.println("ingrese dosis del medicamento");
		String medicationDosage = reader.nextLine();
		medicalHistoryInputsValidator.medicationDosageValidator(medicationDosage);
		System.out.println("-------------------------------");
		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto(date, idPet, idOwner, reason, symptoms, procedure,
				medicine, vaccination, allergy, procedureDetails, diagnosis, medicationDosage);
		vetService.createHistory(medicalHistoryDto);

	}

	private void searchHistory() throws Exception {
		long viewHistory = 1;
		System.out.println("-------------------------------\n" + "Ingrese el ID de la mascota");
		long idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto(idPet, viewHistory);
		vetService.searchHistory(medicalHistoryDto);
		System.out.println("-------------------------------\n" + "Ingrese el N* de la historia clinica a visualizar");
		viewHistory = medicalHistoryInputsValidator.idHistoryMValidator(reader.nextLine());
		MedicalHistoryDto medicalHistoryDto2 = new MedicalHistoryDto(idPet, viewHistory);
		vetService.viewHistory(medicalHistoryDto2);
		// MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto(idPet);
		// vetService.searchHistory(medicalHistoryDto);
	}

	public void viewOrder() throws Exception {
		long viewHistory = 1;
		System.out.println("-------------------------------\n" + "Ingrese el ID de la mascota");
		long idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto(idPet, viewHistory);
		vetService.searchOrder(medicalHistoryDto);

		System.out.println("-------------------------------\n" + "Ingrese el N* de la orden a visualizar");
		viewHistory = medicalHistoryInputsValidator.idHistoryMValidator(reader.nextLine());
		MedicalHistoryDto medicalHistoryDto2 = new MedicalHistoryDto(idPet, viewHistory);
		vetService.viewOrder(medicalHistoryDto2);

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

	private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			createHistory();
			return true;
		}
		case "2": {
			searchHistory();
			return true;
		}

		case "4": {
			viewOrder();
			return true;
		}

		case "6": {
			createPet();
			return true;
		}
		case "7": {
			createOwner();
			return true;
		}
		case "8": {

			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

}
