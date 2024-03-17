package app.dto;

public class PetDto {

	private long idOwner;
	private long idPet;
	private String name;
	private int age;
	private String breed;
	private String species;
	private String characteristics;
	private double weight;

	public PetDto() {
		super();
	}

	public PetDto(long idOwner, String name, int age, String breed, String species, String characteristics,
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

	public long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(long idOwner) {
		this.idOwner = idOwner;
	}

	public long getIdPet() {
		return idPet;
	}

	public void setIdPet(long idPet) {
		this.idPet = idPet;
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
