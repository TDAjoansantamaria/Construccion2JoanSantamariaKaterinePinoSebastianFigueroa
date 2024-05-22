package tdea.construccion2.app.dto;

import tdea.construccion2.app.models.MedicalHistory;
import tdea.construccion2.app.models.Order;

public class MedicalHistoryDto {

	private long date;
	private PetDto idPet;
	private PersonDto idOwner;
	private PersonDto idDoctor;
	private long viewHistory;
	private String reason;
	private String symptoms;
	private String procedure;
	private String medicine;
	private long idorder;
	private String vaccination;
	private String allergy;
	private String procedureDetails;
	private String diagnosis;
	private String medicationDosage;
	
	public MedicalHistoryDto() {
		
	}

	public MedicalHistoryDto(long date, PetDto idPet, PersonDto idOwner,PersonDto idDoctor,String reason, String symptoms,
			String procedure, String medicine,long idorder, String vaccination, String allergy, String procedureDetails,
			String diagnosis, String medicationDosage) {
		super();
		this.date = date;
		this.idPet = idPet;
		this.idOwner = idOwner;
		this.idDoctor = idDoctor;
		this.reason = reason;
		this.symptoms = symptoms;
		this.procedure = procedure;
		this.medicine = medicine;
		this.idorder = idorder;
		this.vaccination = vaccination;
		this.allergy = allergy;
		this.procedureDetails = procedureDetails;
		this.diagnosis = diagnosis;
		this.medicationDosage = medicationDosage;
		// this.ordercancelation = ordercancelation;
	}

	public MedicalHistoryDto(PetDto idPet, long viewHistory) {
		super();
		this.idPet = idPet;
		this.viewHistory = viewHistory;
	}



	public MedicalHistoryDto(MedicalHistory medicalHistory) {
		// TODO Auto-generated constructor stub
	}

	public MedicalHistoryDto(Order order) {
		// TODO Auto-generated constructor stub
	}

	public long getViewHistory() {
		return viewHistory;
	}

	public void setViewHistory(long viewHistory) {
		this.viewHistory = viewHistory;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public PetDto getIdPet() {
		return idPet;
	}

	public void setIdPet(PetDto idPet) {
		this.idPet = idPet;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedure_details) {
		this.procedureDetails = procedure_details;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getMedicationDosage() {
		return medicationDosage;
	}

	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}

	 //public String getOrdercancelation() {
	// return ordercancelation;
	// }

	// public void setOrdercancelation(String ordercancelation) {
	// this.ordercancelation = ordercancelation;
	// }

	public PersonDto getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(PersonDto idOwner) {
		this.idOwner = idOwner;
	}

	public PersonDto getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(PersonDto idDoctor) {
		this.idDoctor = idDoctor;
	}


    public long getidorder() {
		
		return idorder;
	}

	public void setidorder(long idorder) {
		this.idorder = idorder;
	}

}
