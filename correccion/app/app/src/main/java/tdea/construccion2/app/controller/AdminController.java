package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.service.AdminService;
import tdea.construccion2.app.service.VeterinarianService;
import tdea.construccion2.app.validators.PersonInputsValidator;

@Component
public class AdminController {
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private VeterinarianService veterinarianService;
	@Autowired
	private AdminService adminService;

	private static Scanner reader = new Scanner(System.in);
	private static final String MENU = "-------------------------------\n" + "           Menu\n"
			+ "-------------------------------\n" + "1.Crear Usuario \n" + "2.Para cerrar Sesion \n"
			+ "-------------------------------\n";

	private void createUser() throws Exception {

		System.out.println("-------------------------------");
		System.out.println("ingrese la cedula del usuario");
		Long id = personInputValidator.idValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese el nombre completo");
		String fullName = reader.nextLine();
		personInputValidator.fullNameValidator(fullName);
		System.out.println("-------------------------------");
		System.out.println("ingrese la edad");
		int age = personInputValidator.ageValidator(reader.nextLine());
		System.out.println("-------------------------------");
		System.out.println("ingrese numero del rol");
		System.out.println("1.Administrador \n" + "2.Vendedor\n" + "3.Medico Veterinario");
		String role = reader.nextLine();
		switch (role) {
		case "1": {
			role = "Administrador";
			break;
		}
		case "2": {
			role = "Vendedor";
			break;
		}
		case "3": {
			role = "Medico";
			break;
		}
		}

		personInputValidator.roleValidator(role);
		System.out.println("-------------------------------");
		System.out.println("ingrese nombre de usuario");
		String userName = reader.nextLine();
		personInputValidator.userNameValidator(userName);
		System.out.println("-------------------------------");
		System.out.println("ingrese la contraseña");
		String password = reader.nextLine();
		System.out.println("-------------------------------");
		personInputValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(id, fullName, age, role, userName, password);
		adminService.createUser(personDto);
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
			createUser();
			return true;
		}
		case "2": {
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

	public PersonInputsValidator getPersonInputValidator() {
		return personInputValidator;
	}

	public void setPersonInputValidator(PersonInputsValidator personInputValidator) {
		this.personInputValidator = personInputValidator;
	}

	public VeterinarianService getVeterinarianService() {
		return veterinarianService;
	}

	public void setVeterinarianService(VeterinarianService veterinarianService) {
		this.veterinarianService = veterinarianService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
