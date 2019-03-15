package org.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.rest.dto.AnimalDto;
import org.rest.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

	@Autowired
	AnimalService service;
	
	
	@RequestMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	String welcomeAnimal() {
		return "hello animal , hope you are good";
	}

	@RequestMapping(value = "/getAnimal", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	AnimalDto getDummyAnimal() {
		AnimalDto dto = new AnimalDto("human being", "yumraaj", 900);
		return dto;
	}
	
	
	@RequestMapping(value = "/getListAnimal", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	List<AnimalDto> getListOfAnimal() {
		return Arrays.asList(new AnimalDto("human being", "yumraaj", 900) ,
				new AnimalDto("dog", "entertimnet", 12),
				new AnimalDto("cat", "tom", 2),
				new AnimalDto("lion", "simba", 15));
	}
	
	
	@RequestMapping(value = "/saveAnimal", consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.POST)
	AnimalDto saveAnimal(@RequestBody AnimalDto animal) {
		System.out.println(animal);
	
		return animal;
	}
	
	
	
}
