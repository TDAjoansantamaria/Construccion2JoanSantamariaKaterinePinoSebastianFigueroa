package app.service;

import app.dto.PersonDto;

public interface AdminService {
	public void createUser(PersonDto personDto) throws Exception;

	public void createOwner(PersonDto personDto) throws Exception;
}
