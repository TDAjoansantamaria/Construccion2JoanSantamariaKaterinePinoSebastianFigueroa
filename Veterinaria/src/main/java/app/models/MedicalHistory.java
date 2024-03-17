package app.models;

import java.sql.Date;

public class MedicalHistory {

	private Date medicalHistoryDate;
	// private Person veterinarian;
	private String reasonForConsultation;
	private String symptomatology;
	private String diagnosis;
	private String procedure;
	private String medication;
	private String medicationDosage;
	private String vaccinationHistory;
	private String allergic;
	private String procedureDetails;
	private String orderCancellation;

	public MedicalHistory() {
		this.medicalHistoryDate = new Date(System.currentTimeMillis());
	}

	public Date getMedicalHistoryDate() {
		return medicalHistoryDate;
	}

	public void setMedicalHistoryDate(Date medicalHistoryDate) {
		this.medicalHistoryDate = medicalHistoryDate;
	}

	/*
	 * public Person getVeterinarian() { return veterinarian; }
	 * 
	 * public void setVeterinarian(Person veterinarian) { this.veterinarian =
	 * veterinarian; }
	 */
	public String getReasonForConsultation() {
		return reasonForConsultation;
	}

	public void setReasonForConsultation(String reasonForConsultation) {
		this.reasonForConsultation = reasonForConsultation;
	}

	public String getSymptomatology() {
		return symptomatology;
	}

	public void setSymptomatology(String symptomatology) {
		this.symptomatology = symptomatology;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getVaccinationHistory() {
		return vaccinationHistory;
	}

	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}

	public String getAllergic() {
		return allergic;
	}

	public void setAllergicMedications(String allergic) {
		this.allergic = allergic;
	}

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
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

	public String getOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(String orderCancellation) {
		this.orderCancellation = orderCancellation;
	}

}
