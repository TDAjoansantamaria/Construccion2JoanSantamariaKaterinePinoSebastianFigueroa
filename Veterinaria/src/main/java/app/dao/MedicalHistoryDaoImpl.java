package app.dao;

import java.sql.Connection;
import java.sql.Date;

import app.dto.SessionDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import app.config.MYSQLConnection;
import app.dto.MedicalHistoryDto;

public class MedicalHistoryDaoImpl implements MedicalHistoryDao {
	public Connection connection = MYSQLConnection.getConnection();
	public static SessionDto sessionDto = new SessionDto();

	@Override
	public void createHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {
		long resutIdOrder = 0;
		long resutIdDoctor = 0;
		String resultFullName = "";

		String query4 = "SELECT IDPERSON,FULLNAME FROM SESION INNER JOIN PERSON ON SESION.USERNAME = PERSON.USERNAME ORDER BY ID DESC LIMIT 1";
		PreparedStatement preparedStatement4 = connection.prepareStatement(query4);
		ResultSet resultSet2 = preparedStatement4.executeQuery();
		if (resultSet2.next()) {
			resutIdDoctor = resultSet2.getLong("IDPERSON");
			resultFullName = resultSet2.getString("FULLNAME");
			resultSet2.close();
			preparedStatement4.close();
		}

		String query2 = "INSERT INTO ORDERHC(IDPET,IDOWNER,IDDOCTOR,MEDICINE,DATEORDER,ORDERCANCELLATION) VALUES (?,?,?,?,?,'Active')";
		PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
		int j = 1;
		preparedStatement2.setLong(j++, medicalHistoryDto.getIdPet());
		preparedStatement2.setLong(j++, medicalHistoryDto.getIdOwner());
		preparedStatement2.setLong(j++, resutIdDoctor);
		preparedStatement2.setString(j++, medicalHistoryDto.getMedicine());
		preparedStatement2.setLong(j++, medicalHistoryDto.getDate());
		preparedStatement2.execute();

		String query3 = "SELECT IDORDER FROM ORDERHC WHERE DATEORDER=?";
		PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
		preparedStatement3.setLong(1, medicalHistoryDto.getDate());
		ResultSet resultSet = preparedStatement3.executeQuery();
		if (resultSet.next()) {
			resutIdOrder = resultSet.getLong("IDORDER");
			resultSet.close();
			preparedStatement3.close();
		}

		String query = "INSERT INTO HISTORY(DATE,PET,DOCTOR,OWNER,REASON,SYMPTOMS,PROCEDURES,MEDICINE,ORDERS,VACCINATION,ALLERGY,"
				+ "DETAILS,DIAGNOSIS,MEDICATIONDOSAGE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, medicalHistoryDto.getDate());
		preparedStatement.setLong(i++, medicalHistoryDto.getIdPet());
		preparedStatement.setLong(i++, resutIdDoctor);
		preparedStatement.setLong(i++, medicalHistoryDto.getIdOwner());
		preparedStatement.setString(i++, medicalHistoryDto.getReason());
		preparedStatement.setString(i++, medicalHistoryDto.getSymptoms());
		preparedStatement.setString(i++, medicalHistoryDto.getProcedure());
		preparedStatement.setString(i++, medicalHistoryDto.getMedicine());
		preparedStatement.setLong(i++, resutIdOrder);
		preparedStatement.setString(i++, medicalHistoryDto.getVaccination());
		preparedStatement.setString(i++, medicalHistoryDto.getAllergy());
		preparedStatement.setString(i++, medicalHistoryDto.getProcedureDetails());
		preparedStatement.setString(i++, medicalHistoryDto.getDiagnosis());
		preparedStatement.setString(i++, medicalHistoryDto.getMedicationDosage());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void searchHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {

		String query = "SELECT * FROM HISTORY INNER JOIN PET ON HISTORY.PET = PET.IDPET INNER JOIN PERSON ON HISTORY.OWNER= PERSON.IDPERSON "
				+ "INNER JOIN ORDERHC ON HISTORY.ORDERS = ORDERHC.IDORDER WHERE HISTORY.PET = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getIdPet());
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------- \n"
						+ "                                     HISTORIAS CREADAS EN EL SISTEMA\n"
						+ "----------------------------------------------------------------------------------------------------------------- \n"
						+ "      N*              FECHA        MASCOTA        PROPIETARIO           MEDICO          ID ORDEN     ESTADO ORDEN \n"
						+ "-----------------------------------------------------------------------------------------------------------------");

		int i = 1;
		while (resultSet.next()) {
			String query2 = "SELECT * FROM HISTORY INNER JOIN PERSON ON HISTORY.DOCTOR=PERSON.IDPERSON WHERE DOCTOR = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setLong(1, resultSet.getLong("DOCTOR"));
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			if (resultSet2.next()) {
			}
			long date = resultSet.getLong("DATE");
			Date date1 = new Date(date);
			String date2 = date1.toString();
			System.out.println(
					resultSet.getString("DATE") + "  --  " + date2 + "  --  " + resultSet.getString("NAME") + "  --  "
							+ resultSet.getString("FULLNAME") + "  --  " + resultSet2.getString("FULLNAME") + "  --    "
							+ resultSet.getLong("ORDERS") + "     --     " + resultSet.getString("ORDERCANCELLATION"));

		}
		resultSet.close();
		preparedStatement.close();
	}

	@Override
	public void viewHistory(MedicalHistoryDto medicalHistoryDto) throws Exception {

		String query3 = "SELECT * FROM HISTORY WHERE DATE = ?";
		PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
		preparedStatement3.setLong(1, medicalHistoryDto.getViewHistory());
		ResultSet resultSet3 = preparedStatement3.executeQuery();
		if (resultSet3.next()) {
		}

		String query = "SELECT * FROM HISTORY INNER JOIN PET ON HISTORY.PET = PET.IDPET INNER JOIN PERSON ON HISTORY.OWNER= PERSON.IDPERSON "
				+ "INNER JOIN ORDERHC ON HISTORY.ORDERS = ORDERHC.IDORDER WHERE PET = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, resultSet3.getLong("PET"));
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
		}
		String query2 = "SELECT * FROM HISTORY INNER JOIN PERSON ON HISTORY.DOCTOR=PERSON.IDPERSON WHERE DOCTOR = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
		preparedStatement2.setLong(1, resultSet3.getLong("DOCTOR"));
		ResultSet resultSet2 = preparedStatement2.executeQuery();
		if (resultSet2.next()) {
		}

		long date = resultSet3.getLong("DATE");
		Date date1 = new Date(date);
		String date2 = date1.toString();
		System.out.println("------------------------------------------------------------------------------------ \n"
				+ "                HISTORIA MEDICA # " + medicalHistoryDto.getViewHistory() + "\n"
				+ "-------------------------------------------------------------------------- \n"
				+ " Fecha elaboración: " + date2 + "\n" + "-----------------------------------------\n"
				+ " Codigo medico veterinario:        " + resultSet3.getLong("DOCTOR") + "\n"
				+ " Nombre del medico:                " + resultSet2.getString("FULLNAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Codigo mascota:                   " + resultSet3.getLong("PET") + "\n"
				+ " Nombre de mascota:                " + resultSet.getString("NAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Cedula propietario:               " + resultSet3.getLong("OWNER") + "\n"
				+ " Nombre del propietario:           " + resultSet.getString("FULLNAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Razon de la consulta:             " + resultSet3.getString("REASON") + "\n"
				+ " Sintomas:                         " + resultSet3.getString("SYMPTOMS") + "\n"
				+ " Procedimiento:                    " + resultSet3.getString("PROCEDURES") + "\n"
				+ " Medicamento:                      " + resultSet3.getString("MEDICINE") + "\n"
				+ " Codigo de Orden:                  " + resultSet3.getLong("ORDERS") + "\n"
				+ " Estado de la Orden:               " + resultSet.getString("ORDERCANCELLATION") + "\n"
				+ " Vacunación:                       " + resultSet3.getString("VACCINATION") + "\n"
				+ " Alergias:                         " + resultSet3.getString("ALLERGY") + "\n"
				+ " Detalle:                          " + resultSet3.getString("DETAILS") + "\n"
				+ " Diagnostico:                      " + resultSet3.getString("DIAGNOSIS") + "\n"
				+ " Dosis del medicamento:            " + resultSet3.getString("MEDICATIONDOSAGE"));
		System.out.println();

		resultSet.close();
		preparedStatement.close();
		resultSet2.close();
		preparedStatement2.close();
		resultSet3.close();
		preparedStatement3.close();

	}

	@Override
	public void searchOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {

		String query = "SELECT * FROM ORDERHC INNER JOIN PET ON ORDERHC.IDPET = PET.IDPET INNER JOIN PERSON ON ORDERHC.IDOWNER= PERSON.IDPERSON "
				+ "INNER JOIN HISTORY ON HISTORY.ORDERS = ORDERHC.IDORDER WHERE ORDERHC.IDPET = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getIdPet());
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------- \n"
						+ "                                     HISTORIAS CREADAS EN EL SISTEMA\n"
						+ "----------------------------------------------------------------------------------------------------------------- \n"
						+ "      N*          FECHA        MASCOTA        PROPIETARIO           MEDICO          ID ORDEN     ESTADO ORDEN \n"
						+ "-----------------------------------------------------------------------------------------------------------------");

		int i = 1;
		while (resultSet.next()) {
			String query2 = "SELECT * FROM ORDERHC INNER JOIN PERSON ON ORDERHC.IDDOCTOR=PERSON.IDPERSON WHERE ORDERHC.IDDOCTOR = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setLong(1, resultSet.getLong("IDDOCTOR"));
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			if (resultSet2.next()) {
			}
			long date = resultSet.getLong("DATE");
			Date date1 = new Date(date);
			String date2 = date1.toString();
			System.out.println(resultSet.getString("IDORDER") + "  --  " + date2 + "  --  "
					+ resultSet.getString("NAME") + "  --  " + resultSet.getString("FULLNAME") + "  --  "
					+ resultSet2.getString("FULLNAME") + "  --    " + resultSet.getLong("IDORDER") + "     --     "
					+ resultSet.getString("MEDICINE") + "     --     " + resultSet.getString("ORDERCANCELLATION"));

		}
		resultSet.close();
		preparedStatement.close();
	}

	@Override
	public void viewOrder(MedicalHistoryDto medicalHistoryDto) throws Exception {

		String query3 = "SELECT * FROM ORDERHC WHERE IDORDER = ?";
		PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
		preparedStatement3.setLong(1, medicalHistoryDto.getViewHistory());
		ResultSet resultSet3 = preparedStatement3.executeQuery();
		if (resultSet3.next()) {
		}
		String query = "SELECT * FROM ORDERHC INNER JOIN PET ON ORDERHC.IDPET = PET.IDPET INNER JOIN PERSON ON ORDERHC.IDOWNER= PERSON.IDPERSON "
				+ "INNER JOIN HISTORY ON HISTORY.PET = ORDERHC.IDPET WHERE ORDERHC.IDORDER = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getViewHistory());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
		}
		String query2 = "SELECT * FROM ORDERHC INNER JOIN PERSON ON ORDERHC.IDDOCTOR=PERSON.IDPERSON WHERE ORDERHC.IDDOCTOR = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
		preparedStatement2.setLong(1, resultSet3.getLong("IDDOCTOR"));
		ResultSet resultSet2 = preparedStatement2.executeQuery();
		if (resultSet2.next()) {
		}
		long date = resultSet.getLong("DATE");
		Date date1 = new Date(date);
		String date2 = date1.toString();

		System.out.println("--------------------------------------------------------------------------------\n"
				+ "                ORDEN MEDICA # " + resultSet3.getLong("IDORDER") + "\n"
				+ "---------------------------------------------------------------------- \n"
				+ " Fecha elaboración:    " + date2 + "\n" + " Estado de la orden:   "
				+ resultSet.getString("ORDERCANCELLATION") + "\n" + "-----------------------------------------\n"
				+ " Codigo medico veterinario:        " + resultSet.getLong("IDDOCTOR") + "\n"
				+ " Nombre del medico:                " + resultSet2.getString("FULLNAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Codigo mascota:                   " + resultSet.getLong("IDPET") + "\n"
				+ " Nombre de mascota:                " + resultSet.getString("NAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Cedula propietario:               " + resultSet.getLong("IDOWNER") + "\n"
				+ " Nombre del propietario:           " + resultSet.getString("FULLNAME") + "\n"
				+ "-------------------------------------------------------------------------\n"
				+ " Medicamento:                      " + resultSet.getString("MEDICINE") + "\n"
				+ " Dosis del medicamento:            " + resultSet.getString("MEDICATIONDOSAGE"));
		System.out.println();
		resultSet.close();
		preparedStatement.close();
		resultSet2.close();
		preparedStatement2.close();
		resultSet3.close();
		preparedStatement3.close();

	}

	public boolean findHistoryByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		String query = "SELECT 1 FROM HISTORY WHERE DATE = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getDate());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean result = resulSet.next();
		resulSet.close();
		preparedStatement.close();

		return result;

	}

	public boolean findHistoryByPetExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		String query = "SELECT 1 FROM HISTORY WHERE PET = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getIdPet());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean result = resulSet.next();
		resulSet.close();
		preparedStatement.close();

		return result;

	}

	public boolean findOrderByDateExist(MedicalHistoryDto medicalHistoryDto) throws Exception {
		String query = "SELECT 1 FROM ORDERHC WHERE IDORDER = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, medicalHistoryDto.getViewHistory());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean result = resulSet.next();
		resulSet.close();
		preparedStatement.close();

		return result;

	}

}
