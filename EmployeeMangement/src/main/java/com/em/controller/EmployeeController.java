package com.em.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.em.dto.Employee;

@Controller
public class EmployeeController {
	
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	@GetMapping("/")
	public 	String index(){
		return "index";
	}

	@RequestMapping(value ="/saveEmployee" , method = RequestMethod.POST)
	String saveEmployee(Employee employee , BindingResult result){
		if(result.hasErrors()) {
			return "index";
		}
		System.out.println(employee);
		return "employeeDetails";
	}

	public EmployeeController() {
		System.out.println("emp comtroller created");
	}
	
	
	
	
}
