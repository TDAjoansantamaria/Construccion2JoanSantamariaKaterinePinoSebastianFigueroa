package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.PetDto;
import tdea.construccion2.app.models.Pet;
import tdea.construccion2.app.repository.PetRepository;

@Service
public class PetDaoImpl implements PetDao {
	@Autowired
	private PetRepository petRepository;

	@Override
	public void createPet(PetDto petDto) throws Exception {
		Pet pet = new Pet(petDto);
		petRepository.save(pet);
	}

	public PetDto findPetById(PetDto petDto) throws Exception {
		Pet pet = petRepository.findById(petDto.getIdPet());
		if (pet == null) {
			return null;
		}
		return new PetDto(pet);
	}

	public PetRepository getPetRepository() {
		return petRepository;
	}

	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public boolean findPetExist(PetDto petDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
