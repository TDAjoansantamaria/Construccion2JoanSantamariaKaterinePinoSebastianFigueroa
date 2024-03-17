package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.models.Person;

public class PersonDaoImpl implements PersonDao {
	public Connection connection = MYSQLConnection.getConnection();

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		String query = "INSERT INTO PERSON(IDPERSON,FULLNAME,AGE,USERNAME,PASSWORD,ROLE) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, personDto.getIdPerson());
		preparedStatement.setString(i++, personDto.getFullName());
		preparedStatement.setInt(i++, personDto.getAge());
		preparedStatement.setString(i++, personDto.getUserName());
		preparedStatement.setString(i++, personDto.getPassword());
		preparedStatement.setString(i++, personDto.getRole());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public boolean findUserExist(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE IDPERSON = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, personDto.getIdPerson());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PersonDto findUserById(PersonDto personDto) throws Exception {
		String query = "SELECT IDPERSON,FULLNAME,AGE,USERNAME,PASSWORD,ROLE FROM PERSON WHERE IDPERSON = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, personDto.getIdPerson());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Person person = new Person();
			person.setIdPerson(resulSet.getLong("IDPERSON"));
			person.setFullName(resulSet.getString("FULLNAME"));
			person.setAge(resulSet.getInt("AGE"));
			person.setRole(resulSet.getString("ROLE"));
			person.setUserName(resulSet.getString("USERNAME"));
			person.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return new PersonDto(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

	@Override
	public boolean existUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT IDPERSON,FULLNAME,AGE,USERNAME,PASSWORD,ROLE FROM PERSON WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Person person = new Person();
			person.setIdPerson(resulSet.getLong("IDPERSON"));
			person.setFullName(resulSet.getString("FULLNAME"));
			person.setAge(resulSet.getInt("AGE"));
			person.setRole(resulSet.getString("ROLE"));
			person.setUserName(resulSet.getString("USERNAME"));
			person.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return new PersonDto(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

}