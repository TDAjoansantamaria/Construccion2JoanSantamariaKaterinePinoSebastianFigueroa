package app.service;

import java.util.Arrays;
import java.util.List;
import app.dao.PersonDao;
import app.dao.PersonDaoImpl;
import app.dao.MedicalHistoryDao;
import app.dao.MedicalHistoryDaoImpl;
import app.dto.InvoiceDto;
import app.dto.MedicalHistoryDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.dao.PetDao;
import app.dao.PetDaoImpl;
import app.dto.SessionDto;
import app.dao.LoginDao;
import app.dao.LoginDaoImp;
import app.dao.InvoiceDao;
import app.dao.InvoiceDaoImpl;

public class VeterinarianService implements LoginService, AdminService, VetService, SellerService {
	List<String> roles = Arrays.asList("Administrador", "Vendedor", "Medico");
	List<String> specie = Arrays.asList("Perro", "Gato", "Pez", "Ave");
	private static long sessionId = 0L;

	@Override
	public void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRole())) {
			throw new Exception("el rol no es valido");
		}
		PersonDao personDao = new PersonDaoImpl();
		if (personDao.findUserExist(personDto)) {
			throw new Exception("ya existe un usuario con esa cedula");
		}
		if (personDao.existUserByUserName(personDto)) {
			throw new Exception("ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("se ha creado el usuario");

	}

	@Override
	public void createOwner(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDaoImpl();
		if (personDao.findUserExist(personDto)) {
			throw new Exception("ya existe un usuario con esa cedula");
		}
		personDao.createPerson(personDto);
		System.out.println("se ha creado el dueño");

	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		if (!specie.contains(petDto.getSpecies())) {
			throw new Exception("la especie no es valido");
		}
		PetDao petDao = new PetDaoImpl();
		petDao.createPet(petDto);
		System.out.println("se ha creado la mascota");

	}

	@Override
	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {

		LoginDao loginDao = new LoginDaoImp();
		SessionDto sessionDto = loginDao.findSessionById(sessionId);
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}

		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		PetDao petDao = new PetDaoImpl();
		PetDto petDto = new PetDto();

		petDto.setIdPet(medicalHistoryDto.getIdPet());
		if (!petDao.findPetExist(petDto)) {
			throw new Exception("No existe la mascota");
		}
		PersonDao personDao1 = new PersonDaoImpl();
		PersonDto personDto1 = new PersonDto();
		personDto1.setIdPerson(medicalHistoryDto.getIdOwner());
		if (!personDao1.findUserExist(personDto1)) {
			throw new Exception("No existe el dueño");
		}

		personDto.setIdPerson(medicalHistoryDto.getIdDoctor());
		medicalHistoryDao.createHistory(medicalHistoryDto);
		System.out.println("se ha creado la Historia Medica");

	}

	@Override
	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		PetDao petDao = new PetDaoImpl();
		PetDto petDto = new PetDto();

		petDto.setIdPet(medicalHistoryDto.getIdPet());
		if (!petDao.findPetExist(petDto)) {
			throw new Exception("No existe la mascota");
		}

		medicalHistoryDto.setIdPet(medicalHistoryDto.getIdPet());
		if (!medicalHistoryDao.findHistoryByPetExist(medicalHistoryDto)) {
			throw new Exception("No existe historia medica");
		}

		medicalHistoryDao.searchHistory(medicalHistoryDto);

	}

	@Override
	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		medicalHistoryDto.setDate(medicalHistoryDto.getViewHistory());
		if (!medicalHistoryDao.findHistoryByDateExist(medicalHistoryDto)) {
			throw new Exception("No existe historia medica");
		}
		medicalHistoryDao.viewHistory(medicalHistoryDto);
	}

	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRole(personDtoValidate.getRole());
		LoginDao loginDao = new LoginDaoImp();

		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		// System.out.println("Usuario: " + sesionDto.getUserName() + " -- Inicia la
		// sesion #" + sessionId);

	}

	@Override
	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {

		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		medicalHistoryDto.setViewHistory(medicalHistoryDto.getViewHistory());
		if (!medicalHistoryDao.findOrderByDateExist(medicalHistoryDto)) {
			throw new Exception("No existe la orden medica");
		}
		medicalHistoryDao.viewOrder(medicalHistoryDto);

	}

	@Override
	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		PetDao petDao = new PetDaoImpl();
		PetDto petDto = new PetDto();

		petDto.setIdPet(medicalHistoryDto.getIdPet());
		if (!petDao.findPetExist(petDto)) {
			throw new Exception("No existe ordenes para la mascota");
		}
		medicalHistoryDao.searchOrder(medicalHistoryDto);
	}

	@Override
	public void createInvoice(InvoiceDto invoiceDto) throws Exception {
		InvoiceDao invoiceDao = new InvoiceDaoImpl();

		invoiceDao.createInvoice(invoiceDto);
	}

	@Override
	public void logout() throws Exception {
		LoginDao loginDao = new LoginDaoImp();
		loginDao.logout(sessionId);
		setSesionID(0);
	}

	@Override
	public void searchInvoice(InvoiceDto invoiceDto) throws Exception {
		// TODO Auto-generated method stub

	}
}