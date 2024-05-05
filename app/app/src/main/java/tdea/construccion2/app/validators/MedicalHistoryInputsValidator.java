package tdea.construccion2.app.validators;
import org.springframework.stereotype.Component;

@Component
public class MedicalHistoryInputsValidator extends InputsValidator {
	public int idPetValidator(String idPet) throws Exception {
		return super.integerValidator(idPet, "id de mascota HC");
	}

	public long viewHistoryValidator(String viewHistory) throws Exception {
		return super.longValidator(viewHistory, "Codigo de la HC");
	}

	public long idDoctorValidator(String idDoctor) throws Exception {
		return super.longValidator(idDoctor, "id del medico veterinario");
	}

	public long idOwnerValidator(String idOwner) throws Exception {
		return super.longValidator(idOwner, "id del dueño HC");
	}

	public long idHistoryMValidator(String idHistoryM) throws Exception {
		return super.longValidator(idHistoryM, "id de la consulta");
	}

	public void reasonValidator(String reason) throws Exception {
		super.stringValidator(reason, "motivo consulta HC");
	}

	public void symptomsValidator(String symptoms) throws Exception {
		super.stringValidator(symptoms, "sintomatologia HC");
	}

	public void procedureValidator(String procedure) throws Exception {
		super.stringValidator(procedure, "procedimiento HC");
	}

	public void medicineValidator(String medicine) throws Exception {
		super.stringValidator(medicine, "medicamento HC");
	}

	public long idOrderValidator(String idOrder) throws Exception {
		return super.longValidator(idOrder, "id de orden HC");
	}

	public void vaccinationValidator(String vaccination) throws Exception {
		super.stringValidator(vaccination, "vacunacion HC");
	}

	public void allergyValidator(String allergy) throws Exception {
		super.stringValidator(allergy, "alergia HC");
	}

	public void procedureDetailsValidator(String procedureDetails) throws Exception {
		super.stringValidator(procedureDetails, "detalle procedimiento HC");
	}

	public void diagnosisValidator(String diagnosis) throws Exception {
		super.stringValidator(diagnosis, "diagnostico HC");
	}

	public void medicationDosageValidator(String medicationDosage) throws Exception {
		super.stringValidator(medicationDosage, "dosis medicamento HC");
	}

	public void ordercancelationValidator(String ordercancelation) throws Exception {
		super.stringValidator(ordercancelation, "orden de cancelacion HC");
	}
}
