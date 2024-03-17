package app.dto;

public class MedicalHistoryDto {

	private long date;
	private long idPet;
	private long idOwner;
	private long idDoctor;
	private long viewHistory;
	private String reason;
	private String symptoms;
	private String procedure;
	private String medicine;
	private String vaccination;
	private String allergy;
	private String procedureDetails;
	private String diagnosis;
	private String medicationDosage;
	// private String ordercancelation;

	public MedicalHistoryDto(long date, long idPet, long idOwner, String reason, String symptoms, String procedure,
			String medicine, String vaccination, String allergy, String procedureDetails, String diagnosis,
			String medicationDosage) {
		super();
		this.date = date;
		this.idPet = idPet;
		this.idOwner = idOwner;
		this.reason = reason;
		this.symptoms = symptoms;
		this.procedure = procedure;
		this.medicine = medicine;
		this.vaccination = vaccination;
		this.allergy = allergy;
		this.procedureDetails = procedureDetails;
		this.diagnosis = diagnosis;
		this.medicationDosage = medicationDosage;
		// this.ordercancelation = ordercancelation;
	}

	public MedicalHistoryDto(long idPet, long viewHistory) {
		super();
		this.idPet = idPet;
		this.viewHistory = viewHistory;
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

	public long getIdPet() {
		return idPet;
	}

	public void setIdPet(long idPet) {
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

	// public String getOrdercancelation() {
	// return ordercancelation;
	// }

	// public void setOrdercancelation(String ordercancelation) {
	// this.ordercancelation = ordercancelation;
	// }

	public long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(long idOwner) {
		this.idOwner = idOwner;
	}

	public long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(long idDoctor) {
		this.idDoctor = idDoctor;
	}

}
