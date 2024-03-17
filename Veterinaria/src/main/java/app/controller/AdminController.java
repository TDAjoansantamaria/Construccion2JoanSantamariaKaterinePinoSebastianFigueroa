package app.controller;

import java.util.Scanner;
import app.dto.PersonDto;
import app.service.AdminService;
import app.service.VeterinarianService;
import app.validators.PersonInputsValidator;

public class AdminController {
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static VeterinarianService veterinarianService = new VeterinarianService();
	private static Scanner reader = new Scanner(System.in);
	private static AdminService adminService = new VeterinarianService();
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

}
