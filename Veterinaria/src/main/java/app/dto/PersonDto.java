package app.dto;

import app.models.Person;

public class PersonDto {

	private long idPerson;
	private String fullName;
	private int age;
	private String userName;
	private String password;
	private String role;

	public PersonDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public PersonDto(long id, String fullName, int age, String role, String userName, String password) {
		this.idPerson = id;
		this.fullName = fullName;
		this.age = age;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}

	public PersonDto(Person person) {
		this.idPerson = person.getIdPerson();
		this.fullName = person.getFullName();
		this.age = person.getAge();
		this.role = person.getRole();
		this.userName = person.getUserName();
		this.password = person.getPassword();
	}

	public PersonDto() {
	}

	public PersonDto(long id) {
		// TODO Auto-generated constructor stub
	}

	public long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
