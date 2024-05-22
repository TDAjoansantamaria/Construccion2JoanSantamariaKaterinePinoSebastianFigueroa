package tdea.construccion2.app.dto;

import tdea.construccion2.app.models.Pet;

public class PetDto {

	private PersonDto idOwner;
	private int idPet;
	private String name;
	private int age;
	private String breed;
	private String species;
	private String characteristics;
	private double weight;

	public PetDto(PetDto petDto) {
		super();
	}

	public PetDto(Pet pet) {
		super();
		this.idOwner = new PersonDto(pet.getIdpet());
		this.name = pet.getName();
		this.age = pet.getAge();
		this.breed = pet.getBreed();
		this.species = pet.getSpecie();
		this.weight = pet.getWeight();
		this.characteristics = null;
		
	}

	
	public PetDto(PersonDto idOwner, String name, int age, String breed, String species, String characteristics,
			double weight) {
		super();
		this.idOwner = idOwner;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.species = species;
		this.weight = weight;
		this.characteristics = characteristics;
	}

	public PetDto() {
		// TODO Auto-generated constructor stub
	}

	public PersonDto getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(PersonDto idOwner) {
		this.idOwner = idOwner;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int petDto) {
		this.idPet = petDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

}
