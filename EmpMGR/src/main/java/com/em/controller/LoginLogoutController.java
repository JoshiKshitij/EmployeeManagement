package com.em.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class LoginLogoutController {
	

	@Autowired
	EmployeeServiceInterface serviceImpl;

	
	@GetMapping("/")
	public String index(Model model) { //
		model.addAttribute("index", "Employee Management");
		return "login";
	}
	
	// @PostMapping(value = "/loginEmp") //
		@RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
		public String login(@RequestParam String loginId, @RequestParam String password, 
				Model model) {

			EmployeeDto empFromDb = serviceImpl.getEmpByLoginId(loginId);
			
			// this line will bind the object to the session
			model.addAttribute("empDto", empFromDb);
			
			System.out.println(empFromDb.getRole());
			
			if (password.equals(empFromDb.getPassword())) {
				if (empFromDb.getRole().equals("admin")) {
					model.addAttribute("welcome",
							"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());

					return "adminpage";
				}
				if (empFromDb.getRole().equals("deptAdmin")) {
					model.addAttribute("welcome",
							"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());

					return "deptadminpage";
				}
				if (empFromDb.getRole().equals("user")) {
					model.addAttribute("welcome",
							"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());
					return "userpage";
				}
			}
			
			return "login";
		}
	
		@GetMapping("/logout")
		public String logout(SessionStatus status ) {
			System.out.println("logged out");
			// to remove all the attributes from session
			status.setComplete();
			return "login";
		}
		
}
