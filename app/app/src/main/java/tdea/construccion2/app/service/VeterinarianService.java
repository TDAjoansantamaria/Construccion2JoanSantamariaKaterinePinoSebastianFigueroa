package tdea.construccion2.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dao.InvoiceDao;
import tdea.construccion2.app.dao.InvoiceDaoImpl;
import tdea.construccion2.app.dao.LoginDao;
import tdea.construccion2.app.dao.MedicalHistoryDao;
import tdea.construccion2.app.dao.MedicalHistoryDaoImpl;
import tdea.construccion2.app.dao.OrderDao;
import tdea.construccion2.app.dao.PersonDao;
import tdea.construccion2.app.dao.PetDao;
import tdea.construccion2.app.dto.InvoiceDto;
import tdea.construccion2.app.dto.MedicalHistoryDto;
import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.dto.SessionDto;
import tdea.construccion2.app.repository.OrderRepository;

@Service
public class VeterinarianService implements LoginService, AdminService, VetService, SellerService {
	List<String> roles = Arrays.asList("Administrador", "Vendedor", "Medico");
	List<String> specie = Arrays.asList("Perro", "Gato", "Pez", "Ave");
	private static long sessionId = 0L;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private PersonDao personDao1;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;
	@Autowired
	private PetDao petDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRole())) {
			throw new Exception("el rol no es valido");
		}
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
		petDao.createPet(petDto);
		System.out.println("se ha creado la mascota");

	}

	@Override
	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		SessionDto sessionDto = loginDao.findSessionById(sessionId);
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
		PetDto petDto = (medicalHistoryDto.getIdPet());
		if (!petDao.findPetExist(petDto)) {
			throw new Exception("No existe la mascota");
		}

		PersonDto personDto1 = (medicalHistoryDto.getIdOwner());
		if (!personDao1.findUserExist(personDto1)) {
			throw new Exception("No existe el dueño");
		}
         
		OrderDto orderDto = new OrderDto();
		orderDto.setIdPet(petDto);
		orderDto.setIdOwner(personDto1);
		orderDto.setIdDoctor(personDto);
		orderDto.setMedicine(medicalHistoryDto.getMedicine());
		orderDto.setDateOrder(medicalHistoryDto.getDate());
		orderDto.setOrderCancellation("Aceptada");
		orderDto = orderDao.createOrder(orderDto);
		//orderDto = orderRepository.findById(orderDto.getIdorder());
        
		medicalHistoryDto.setIdDoctor(personDto);
		medicalHistoryDto.setidorder(orderDto.getIdorder());
		medicalHistoryDao.createHistory(medicalHistoryDto);
		System.out.println("se ha creado la Historia Medica");

	}

	@Override
	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		PetDto petDto = medicalHistoryDto.getIdPet();
		if (!petDao.findPetExist(petDto)) {
			throw new Exception("No existe la mascota");
		}

		medicalHistoryDto.setViewHistory(medicalHistoryDto.getViewHistory());
		if (!medicalHistoryDao.findHistoryByPetExist(medicalHistoryDto)) {
			throw new Exception("No existe historia medica");
		}

		medicalHistoryDao.searchHistory(medicalHistoryDto);

	}

	@Override
	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
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
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRole(personDtoValidate.getRole());
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("Usuario: " + sesionDto.getUserName() + " -- Inicia la sesion #" + sessionId);
	}

	@Override
	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {
		medicalHistoryDto.setViewHistory(medicalHistoryDto.getViewHistory());
		if (!medicalHistoryDao.findOrderByDateExist(medicalHistoryDto)) {
			throw new Exception("No existe la orden medica");
		}
		medicalHistoryDao.viewOrder(medicalHistoryDto);

	}

	@Override
	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistoryDao medicalHistoryDao = new MedicalHistoryDaoImpl();
		PetDto petDto = (medicalHistoryDto.getIdPet());
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
		loginDao.logout(sessionId);
		setSesionID(0);
	}

	@Override
	public void searchInvoice(InvoiceDto invoiceDto) throws Exception {
		// TODO Auto-generated method stub

	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public PersonDao getPersonDao1() {
		return personDao1;
	}

	public void setPersonDao1(PersonDao personDao1) {
		this.personDao1 = personDao1;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public MedicalHistoryDao getMedicalHistoryDao() {
		return medicalHistoryDao;
	}

	public void setMedicalHistoryDao(MedicalHistoryDao medicalHistoryDao) {
		this.medicalHistoryDao = medicalHistoryDao;
	}

	public PetDao getPetDao() {
		return petDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}

}