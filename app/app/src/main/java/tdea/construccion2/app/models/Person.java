package tdea.construccion2.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tdea.construccion2.app.dto.PersonDto;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@Column(name = "idperson")
	private long idPerson;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "age")
	private int age;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;

	public Person(PersonDto personDto) {
		this.idPerson = personDto.getIdPerson();
		this.fullName = personDto.getFullName();
		this.age = personDto.getAge();
		this.userName = personDto.getUserName();
		this.password = personDto.getPassword();
		this.role = personDto.getRole();
	}

	public Person() {

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
