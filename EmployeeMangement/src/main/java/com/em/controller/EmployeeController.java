package com.em.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	Logger logger = Logger.getLogger(EmployeeController.class);
	
	@GetMapping("/dummyMapping/{name}")
	public 	ModelAndView dummyMehtodTest(@PathVariable ("name")String abc){
		//System.out.println("i am in this dummy method ");
		logger.info(abc);
		return new ModelAndView("dummy.jsp");
	}

	public EmployeeController() {
		System.out.println("emp comtroller created");
		
	}
	
	
	
	
}
