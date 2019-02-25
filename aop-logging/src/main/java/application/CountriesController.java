package application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {
	
	private List<Country> listOfCountires = getListOfCountires();

	private List<Country> getListOfCountires() {
		List<Country> list = new ArrayList<Country>();
		list.add(new Country("India" , 29));
		list.add(new Country("Pakistan" , 5));
		list.add(new Country("Nepal" , 13));
		list.add(new Country("Bhutan" , 10));
		return list;
	}
	
	
	@RequestMapping(value= "getListOfCountires", method = RequestMethod.GET )
	public String getAllCounties() {
		System.out.println("i will gve all countries");
		return listOfCountires.toString();
	}
	
	@RequestMapping(value= "getCountryById/{id}", method = RequestMethod.GET )
	public String getCountryById(@PathVariable ("id")int id) {
		return listOfCountires.get(id).toString();
	}
	
}
