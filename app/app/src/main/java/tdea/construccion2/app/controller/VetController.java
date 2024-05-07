package tdea.construccion2.app.controller;

import java.sql.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.MedicalHistoryDto;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.service.AdminService;
import tdea.construccion2.app.service.VetService;
import tdea.construccion2.app.validators.MedicalHistoryInputsValidator;
import tdea.construccion2.app.validators.PersonInputsValidator;
import tdea.construccion2.app.validators.PetInputsValidator;

@Component
public class VetController {
	@Autowired
	private PetInputsValidator petInputValidator;
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private MedicalHistoryInputsValidator medicalHistoryInputsValidator;
	@Autowired
	private VetService vetService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private static Scanner reader = new Scanner(System.in);

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
		String name = reader.nextLine();
		petInputValidator.namePetValidator(name);
		System.out.println("-------------------------------");
		System.out.println("ingrese la edad de la mascota");
		int age = petInputValidator.ageValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese la Raza:");
		String breed = reader.nextLine();
		petInputValidator.breedValidator(breed);
		System.out.println("-------------------------------");
		System.out.println("ingrese la opcion de especie de la mascota:");
		System.out.println("-------------------------------");
		System.out.println("1. Perro \n" + "2. Gato \n" + "3. Pez \n" + "4. Ave\n");
		System.out.println("-------------------------------");
		String species = reader.nextLine();

		switch (species) {
		case "1": {
			species = "Perro";
			break;
		}
		case "2": {
			species = "Gato";
			break;
		}
		case "3": {
			species = "Pez";
			break;
		}
		case "4": {
			species = "Ave";
			break;
		}
		default: {
			System.out.println("ingrese una opcion valida");
		}

		}

		petInputValidator.speciesValidator(species);

		System.out.println("-------------------------------");
		System.out.println("ingrese las caracteristicas (Color y Tamaño) ");
		String charactercis = reader.nextLine();
		petInputValidator.characteristicsValidator(charactercis);
		System.out.println("ingrese el Peso ");
		double weight = petInputValidator.weightValidator(reader.nextLine());
		PersonDto ownerDto = new PersonDto();
		ownerDto.setIdPerson(idOwner);

		PetDto petDto = new PetDto(ownerDto, name, age, breed, species, charactercis, weight);
		vetService.createPet(petDto);

	}

	private void createOwner() throws Exception {

		System.out.println("-------------------------------");
		System.out.println("ingrese la cedula del dueño");
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
		int idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
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
		System.out.println("-------------------------------");// estoy sin audio asi que manden resumen
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
		PetDto petDto = new PetDto();
		petDto.setIdPet(idPet);
		PersonDto ownerDto = new PersonDto();
		ownerDto.setIdPerson(idOwner);

		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto(date, petDto, ownerDto, null, reason, symptoms,
				procedure, medicine, 0, vaccination, allergy, procedureDetails, diagnosis, medicationDosage);
		vetService.createHistory(medicalHistoryDto);

	}

	private void searchHistory() throws Exception {
		System.out.println("-------------------------------\n" + "Ingrese el ID de la mascota");
		int idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
		PetDto petDto = new PetDto();
		petDto.setIdPet(idPet);
		
		
		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto();
		medicalHistoryDto.setIdPet(petDto);
		
		System.out.println("-------------------------------\n" + "Ingrese el N* de la historia clinica a visualizar");
		long viewHistory = medicalHistoryInputsValidator.idHistoryMValidator(reader.nextLine());
		medicalHistoryDto.setViewHistory(viewHistory);

		vetService.searchHistory(medicalHistoryDto);

		vetService.viewHistory(medicalHistoryDto);

	}

	public void viewOrder() throws Exception {
		System.out.println("-------------------------------\n" + "Ingrese el ID de la mascota");
		int idPet = medicalHistoryInputsValidator.idPetValidator(reader.nextLine());
		PetDto petDto = new PetDto();
		petDto.setIdPet(idPet);
		
		
		MedicalHistoryDto medicalHistoryDto = new MedicalHistoryDto();
		medicalHistoryDto.setIdPet(petDto);
		
		System.out.println("-------------------------------\n" + "Ingrese el N* de la orden a visualizar");
		long viewHistory = medicalHistoryInputsValidator.idHistoryMValidator(reader.nextLine());

		medicalHistoryDto.setViewHistory(viewHistory);
		
		
		vetService.searchOrder(medicalHistoryDto);
		vetService.viewOrder(medicalHistoryDto);

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

	public PetInputsValidator getPetInputValidator() {
		return petInputValidator;
	}

	public void setPetInputValidator(PetInputsValidator petInputValidator) {
		this.petInputValidator = petInputValidator;
	}

	public PersonInputsValidator getPersonInputValidator() {
		return personInputValidator;
	}

	public void setPersonInputValidator(PersonInputsValidator personInputValidator) {
		this.personInputValidator = personInputValidator;
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

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
