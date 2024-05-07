package tdea.construccion2.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.app.dto.PersonDto;
import tdea.construccion2.app.dto.PetDto;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpet")
	private int idpet;
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "idowner")
	private Person idOwner;
	@Column(name = "age")
	private int age;
	@Column(name = "species")
	private String specie;
	@Column(name = "breed")
	private String breed;
	@Column(name = "characteristics")
	private String color;
	@Column(name = "weight")
	private double weight;

	public Pet(PetDto petDto) {
		this.idpet= petDto.getIdPet();
		this.name = petDto.getName();
		this.idOwner = new Person(petDto.getIdOwner());
		this.age = petDto.getAge();
		this.specie = petDto.getSpecies();
		this.breed = petDto.getBreed();
		this.color = petDto.getCharacteristics();
		this.weight = petDto.getWeight();
	}
	
	public Pet() {}

	public Person getOwnerName() {
		return idOwner;
	}

	public void setOwnerName(Person ownerName) {
		this.idOwner = ownerName;
	}

	public Pet(PersonDto idOwner) {
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getOwner() {
		return idOwner;
	}

	public void setOwner(Person ownerName) {
		this.idOwner = ownerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getIdpet() {
		return idpet;
	}

	public void setIdpet(int idpet) {
		this.idpet = idpet;
	}

}
