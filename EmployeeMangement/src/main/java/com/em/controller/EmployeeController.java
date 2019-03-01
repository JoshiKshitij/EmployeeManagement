package com.em.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.em.dto.EmployeeDto;

@Controller
public class EmployeeController {
	
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	@GetMapping("/")
	public 	String index(){
		return "index";
	}
	
	@RequestMapping(value ="/saveEmployee" , method = RequestMethod.POST)
	String saveEmployee(@ModelAttribute EmployeeDto employee ,BindingResult result ){
		if(result.hasErrors()) {
			return "index";
		}
		return "employeeDetails";
	}
	

	public EmployeeController() {
		System.out.println("emp comtroller created");
	}
	
	@RequestMapping(value ="/testRest" , method = RequestMethod.GET)
	String testRest( ){
	String[] s = new String[] {"abc" , "bcd"};
		return Arrays.toString(s);
	}
	
	
	
}
