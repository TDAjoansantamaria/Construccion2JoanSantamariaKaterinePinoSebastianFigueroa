package tdea.construccion2.app.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.MedicalHistoryDto;
import tdea.construccion2.app.dto.SessionDto;
import tdea.construccion2.app.models.MedicalHistory;
import tdea.construccion2.app.models.Person;
import tdea.construccion2.app.models.Pet;
import tdea.construccion2.app.repository.MedicalHistoryRepository;
import tdea.construccion2.app.repository.OrderRepository;
import tdea.construccion2.app.models.Order;

@Service
public class MedicalHistoryDaoImpl implements MedicalHistoryDao {
	public static SessionDto sessionDto = new SessionDto();
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
    private OrderRepository orderRepository;
	@Override
	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistory medicalHistory = new MedicalHistory();
		medicalHistory.setMedicalHistoryDate(medicalHistoryDto.getDate());
		medicalHistory.setPet(new Pet(medicalHistoryDto.getIdPet()));
		medicalHistory.setPerson(new Person(medicalHistoryDto.getIdDoctor()));
		medicalHistory.setPerson1(new Person(medicalHistoryDto.getIdOwner()));
		medicalHistory.setReasonForConsultation(medicalHistoryDto.getReason());
		medicalHistory.setSymptomatology(medicalHistoryDto.getSymptoms());
		medicalHistory.setProcedure(medicalHistoryDto.getProcedure());
		medicalHistory.setMedication(medicalHistoryDto.getMedicine());
		medicalHistory.setOrder(medicalHistoryDto.getidorder());
		medicalHistory.setVaccinationHistory(medicalHistoryDto.getVaccination());
		medicalHistory.setAllergic(medicalHistoryDto.getAllergy());
		medicalHistory.setProcedureDetails(medicalHistoryDto.getProcedureDetails());
		medicalHistory.setDiagnosis(medicalHistoryDto.getDiagnosis());
		medicalHistory.setMedicationDosage(medicalHistoryDto.getMedicationDosage());
		medicalHistoryRepository.save(medicalHistory);
	}

	@Override
	public MedicalHistoryDto searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryDto.getViewHistory());
		if (medicalHistory == null) {
			return null;
		}
		return new MedicalHistoryDto(medicalHistory);
	}

	@Override
	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		Date date2 = new Date(medicalHistoryDto.getDate());
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryDto.getDate());
		System.out.println("------------------------------------------------------------------------------------ \n"
				+ "                HISTORIA MEDICA # " + medicalHistory.getMedicalHistoryDate() + "\n"
				+ "-------------------------------------------------------------------------- \n"
				+ " Fecha elaboración: " + date2 + "\n" + "-----------------------------------------\n"
				+ " Codigo medico veterinario:        " + medicalHistory.getPerson().getIdPerson() + "\n"
				+ " Nombre del medico:                " + medicalHistory.getPerson().getFullName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Codigo mascota:                   " + medicalHistory.getPet().getIdpet() + "\n"
				+ " Nombre de mascota:                " + medicalHistory.getPet().getName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Cedula propietario:               " + medicalHistory.getPerson1().getIdPerson() + "\n"
				+ " Nombre del propietario:           " + medicalHistory.getPerson1().getFullName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Razon de la consulta:             " + medicalHistory.getReasonForConsultation() + "\n"
				+ " Sintomas:                         " + medicalHistory.getSymptomatology() + "\n"
				+ " Procedimiento:                    " + medicalHistory.getProcedure() + "\n"
				+ " Medicamento:                      " + medicalHistory.getMedication() + "\n"
				+ " Codigo de Orden:                  " + medicalHistory.getOrder() + "\n"
				// + " Estado de la Orden: " + medicalHistory. + "\n"
				+ " Vacunación:                       " + medicalHistory.getVaccinationHistory() + "\n"
				+ " Alergias:                         " + medicalHistory.getAllergic() + "\n"
				+ " Detalle:                          " + medicalHistory.getProcedureDetails() + "\n"
				+ " Diagnostico:                      " + medicalHistory.getDiagnosis() + "\n"
				+ " Dosis del medicamento:            " + medicalHistory.getMedicationDosage());
	}

	@Override
	public MedicalHistoryDto searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {
		Order order = orderRepository.findById(medicalHistoryDto.getViewHistory());
		if (order == null) {
			return null;
		}
		
		return new MedicalHistoryDto(order);
	}

	@Override
	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {
		Date date2 = new Date(medicalHistoryDto.getDate());
		Order order = orderRepository.findById(medicalHistoryDto.getDate());
		MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryDto.getDate());

		System.out.println("------------------------------------------------------------------------------------ \n"
				+ "                ORDEN MEDICA # " + order.getDateorder() + "\n"
				+ "-------------------------------------------------------------------------- \n"
				+ " Fecha elaboración: " + date2 + "\n" + "-----------------------------------------\n"
				+ " Codigo medico veterinario:        " + medicalHistory.getPerson().getIdPerson() + "\n"
				+ " Nombre del medico:                " + medicalHistory.getPerson().getFullName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Codigo mascota:                   " + medicalHistory.getPet().getIdpet() + "\n"
				+ " Nombre de mascota:                " + medicalHistory.getPet().getName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Cedula propietario:               " + medicalHistory.getPerson().getIdPerson() + "\n"
				+ " Nombre del propietario:           " + medicalHistory.getPerson().getFullName() + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Medicamento:                      " + medicalHistory.getMedication() + "\n"

				
				
				);

		
	}

	@Override
	public boolean findHistoryByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		return true;

	}

	@Override
	public boolean findHistoryByPetExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		return true;

	}

	@Override
	public boolean findOrderByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		return true;

	}

}
