package tdea.construccion2.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.app.dto.MedicalHistoryDto;

@Entity
@Table(name = "history")
public class MedicalHistory {
	@Id
	@Column(name = "date")
	private long medicalHistoryDate;
	@ManyToOne
	@JoinColumn(name = "pet")
	private Pet pet;
	@ManyToOne
	@JoinColumn(name = "doctor")
	private Person person;
	@ManyToOne
	@JoinColumn(name = "owner")
	private Person person1;
	
	@Column(name = "reason")
	private String reasonForConsultation;
	
	@Column(name = "symptoms")
	private String symptomatology;
	
	@Column(name = "procedures")
	private String procedure;
	
	@Column(name = "medicine")
	private String medication;
	
	@Column(name = "orders")
	private long order;
	
	@Column(name = "vaccination")
	private String vaccinationHistory;
	@Column(name = "allergy")
	private String allergic;
	@Column(name = "details")
	private String procedureDetails;
	@Column(name = "diagnosis")
	private String diagnosis;
	@Column(name = "medicationdosage")
	private String medicationDosage;

	public MedicalHistory(MedicalHistoryDto medicalHistoryDto) {
		this.medicalHistoryDate = medicalHistoryDto.getDate();
		this.pet = new Pet(medicalHistoryDto.getIdPet());
		this.person = new Person(medicalHistoryDto.getIdDoctor());
		this.person1 = new Person(medicalHistoryDto.getIdOwner());
		this.reasonForConsultation = medicalHistoryDto.getReason();
		this.symptomatology = medicalHistoryDto.getSymptoms();
		this.procedure = medicalHistoryDto.getProcedure();
		this.medication = medicalHistoryDto.getMedicine();
		this.order = medicalHistoryDto.getidorder();
		this.vaccinationHistory = medicalHistoryDto.getVaccination();
		this.allergic = medicalHistoryDto.getAllergy();
		this.procedureDetails = medicalHistoryDto.getProcedureDetails();
		this.diagnosis = medicalHistoryDto.getDiagnosis();
		this.medicationDosage = medicalHistoryDto.getMedicationDosage();

	}

	public MedicalHistory() {
		this.medicalHistoryDate = System.currentTimeMillis();
	}

	public Long getMedicalHistoryDate() {
		return medicalHistoryDate;
	}

	public void setMedicalHistoryDate(Long medicalHistoryDate) {
		this.medicalHistoryDate = medicalHistoryDate;
	}

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



	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setPet(Pet pet) {
		this.pet = pet;

	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Pet getPet() {
		return pet;
	}

	public Person getPerson() {
		return person;
	}

	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}

}
