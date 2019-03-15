package org.rest.service;

import org.rest.dao.AnimalRepository;
import org.rest.dto.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository repository;
	
	public AnimalDto saveAnimal(AnimalDto animal){
		return repository.save(animal);
	}
	
	
}
