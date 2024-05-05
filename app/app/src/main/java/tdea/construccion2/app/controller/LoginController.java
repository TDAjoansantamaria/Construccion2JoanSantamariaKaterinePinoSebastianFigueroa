package tdea.construccion2.app.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.service.LoginService;
import tdea.construccion2.app.validators.PersonInputsValidator;
@Component
public class LoginController {
	private static Scanner reader = new Scanner(System.in);
	@Autowired
	private PersonInputsValidator personInputValidator;
	@Autowired
	private LoginService loginService;
	@Autowired
	private AdminController adminController;
	@Autowired
	private VetController vetController;
	@Autowired
	private SellerController sellerController;

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

	public PersonInputsValidator getPersonInputValidator() {
		return personInputValidator;
	}

	public void setPersonInputValidator(PersonInputsValidator personInputValidator) {
		this.personInputValidator = personInputValidator;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public AdminController getAdminController() {
		return adminController;
	}

	public void setAdminController(AdminController adminController) {
		this.adminController = adminController;
	}

	public VetController getVetController() {
		return vetController;
	}

	public void setVetController(VetController vetController) {
		this.vetController = vetController;
	}

	public SellerController getSellerController() {
		return sellerController;
	}

	public void setSellerController(SellerController sellerController) {
		this.sellerController = sellerController;
	}

}
