package app.validators;

public class PetInputsValidator extends InputsValidator {

	public long idPetValidator(String longPet) throws Exception {
		return super.longValidator(longPet, "id de mascota");
	}

	public long idOwnerValidator(String longPet) throws Exception {
		return super.longValidator(longPet, "id de propietario");
	}

	public void namePetValidator(String namePet) throws Exception {
		super.stringValidator(namePet, "nombre de mascota");
	}

	public int ageValidator(String age) throws Exception {
		return super.integerValidator(age, "edad de mascota");
	}

	public double weightValidator(String weight) throws Exception {
		return super.doubleValidator(weight, "peso de la mascota");
	}

	public void breedValidator(String breed) throws Exception {
		super.stringValidator(breed, "raza de mascota");
	}

	public void speciesValidator(String species) throws Exception {
		super.stringValidator(species, "especie de mascota");
	}

	public void colorValidator(String species) throws Exception {
		super.stringValidator(species, "color de mascota");
	}

	public void characteristicsValidator(String characteristics) throws Exception {
		super.stringValidator(characteristics, "caracteristicas de mascota");
	}
}
