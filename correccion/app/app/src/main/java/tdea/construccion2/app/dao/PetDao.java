package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.PetDto;

public interface PetDao {
	public void createPet(PetDto petDto) throws Exception;

	public boolean findPetExist(PetDto petDto) throws Exception;

	//public boolean findById(PetDto petDto) throws Exception;

	public PetDto findPetById(PetDto petDto) throws Exception;
}
