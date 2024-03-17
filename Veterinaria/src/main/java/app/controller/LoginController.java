package app.controller;

import java.util.Scanner;

import app.dto.PersonDto;
import app.service.VeterinarianService;
import app.service.LoginService;
import app.validators.PersonInputsValidator;

public class LoginController {
	private static Scanner reader = new Scanner(System.in);
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static LoginService loginService = new VeterinarianService();
	private static AdminController adminController = new AdminController();
	private static VetController vetController = new VetController();
	private static SellerController sellerController = new SellerController();

	public void login() throws Exception {

		System.out.print("-------------------------------- \n" + "Ingrese su usuario: ");
		String userName = reader.nextLine();
		System.out.print("-------------------------------- \n");
		personInputValidator.userNameValidator(userName);
		System.out.print("Ingrese su contraseña: ");
		String password = reader.nextLine();
		System.out.print("-------------------------------- \n");
		personInputValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(userName, password);
		loginService.login(personDto);
		loginRouter(personDto);
		loginService.logout();
	}

	private void loginRouter(PersonDto personDto) {

		String option = personDto.getRole();
		switch (option) {
		case "Administrador": {
			adminController.session();
			break;
		}
		case "Medico": {
			vetController.session();
			break;
		}
		case "Vendedor": {
			sellerController.session();
			break;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			break;
		}

		}

	}
}
