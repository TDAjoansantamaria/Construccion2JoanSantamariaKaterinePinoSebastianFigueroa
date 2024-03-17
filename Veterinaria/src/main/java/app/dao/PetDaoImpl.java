package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PetDto;

public class PetDaoImpl implements PetDao {
	public Connection connection = MYSQLConnection.getConnection();

	public void createPet(PetDto petDto) throws Exception {
		String query = "INSERT INTO PET (IDOWNER,NAME,AGE,BREED,SPECIES,CHARACTERISTICS,WEIGHT)VALUES ( ?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, petDto.getIdOwner());
		preparedStatement.setString(i++, petDto.getName());
		preparedStatement.setInt(i++, petDto.getAge());
		preparedStatement.setString(i++, petDto.getBreed());
		preparedStatement.setString(i++, petDto.getSpecies());
		preparedStatement.setString(i++, petDto.getCharacteristics());
		preparedStatement.setDouble(i++, petDto.getWeight());
		preparedStatement.execute();
		preparedStatement.close();

	}

	@Override
	public boolean findPetExist(PetDto petDto) throws Exception {
		String query = "SELECT 1 FROM PET WHERE IDPET = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, petDto.getIdPet());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean result = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return result;

	}

}
