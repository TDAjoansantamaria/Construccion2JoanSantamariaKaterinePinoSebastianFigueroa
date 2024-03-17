package app;

import java.util.Scanner;
import app.controller.LoginController;

public class App {
	private static Scanner reader = new Scanner(System.in);
	private static LoginController loginController = new LoginController();

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			try {
				run = runApplication();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.print("deteniendo la aplicacion");
	}

	public static boolean runApplication() throws Exception {
		String menu = "-------------------------------\n" + "      Ingrese una opción       \n"
				+ "-------------------------------\n" + " 1. Para iniciar sesion        \n"
				+ " 2. Para cerrar la aplicacion  \n" + "-------------------------------";
		System.out.println(menu);
		String option = reader.nextLine();
		switch (option) {
		case "1": {
			loginController.login();
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
