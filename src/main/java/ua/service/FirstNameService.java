package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.FirstName;
import ua.repository.FirstNameRepository;

@Service
public class FirstNameService {

	@Autowired
	private FirstNameRepository firstNameRepository;

	public void save(String nameUser) {
		FirstName firstName = new FirstName();
		firstName.setNameUser(nameUser);
		firstNameRepository.save(firstName);
	}

	public Iterable<FirstName> getAll() {
		return firstNameRepository.findAll();
	}

	public void delete(int id){
		firstNameRepository.delete(id);
	}
	
	public FirstName findOne(int id){
		return firstNameRepository.findOne(id);
	}
}
