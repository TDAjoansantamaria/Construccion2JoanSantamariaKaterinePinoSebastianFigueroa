package app.dao;

import app.dto.MedicalHistoryDto;

public interface MedicalHistoryDao {
	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public boolean findHistoryByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public boolean findOrderByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception;

	public boolean findHistoryByPetExist(MedicalHistoryDto medicalHistoryDto) throws Exception;

}
