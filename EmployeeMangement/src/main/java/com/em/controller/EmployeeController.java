package com.em.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceImpl;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl serviceImpl;

	Logger logger = Logger.getLogger(EmployeeController.class);

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("index", "Model test is working");
		return "login";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	String saveEmployee(@ModelAttribute EmployeeDto employee, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		return "employeeDetails";
	}

	public EmployeeController() {
		System.out.println("emp comtroller created");
	}

	@PostMapping(value = "/loginEmp")
	//@RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
	public String login(@RequestParam String loginId, @RequestParam String password, Model model) {
		
		EmployeeDto empFromDb = serviceImpl.getEmpByLoginId(loginId);
		
		model.addAttribute("empDto", empFromDb);
		//model.addAttribute("test", "testvalue");
		
		if (password.equals(empFromDb.getPassword())) {
			if (empFromDb.getRole().equals("admin")) {
				model.addAttribute("welcome",
						"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());
				
				return "adminpage";
			}
			if (empFromDb.getRole().equals("user")) {
				model.addAttribute("welcome",
						"welcome" + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());
				return "userpage";
			}
		}
		return "login";
	}
	
	//@GetMapping("/userProfile")
	@RequestMapping(value = "/userProfile" ,method= RequestMethod.GET)
	public String userprofile(Model model , HttpSession session) {

			Object object = session.getAttribute("empDto");
			
			EmployeeDto emp = (EmployeeDto)object;
		
			model.addAttribute("emp", emp);
			
		return "profilepage";
	}
}
