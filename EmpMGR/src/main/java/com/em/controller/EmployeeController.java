package com.em.controller;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface serviceImpl;


	public EmployeeController() {
		System.out.println("emp comtroller created");
	}

	// @GetMapping("/userProfile")
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String userprofile(Model model, HttpSession session) {

		Object object = session.getAttribute("empDto");
		if (object == null) {
			return "login";
		}
		EmployeeDto emp = (EmployeeDto) object;
		model.addAttribute("emp", emp);
		return "profilepage";
	}

	// display delete page
	@RequestMapping(value = "/deleteAccountPage", method = RequestMethod.GET)
	public String deletePage() {
		return "deleteAccountPage";
	}

	// delete Emp
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpSession session) {
		Object object = session.getAttribute("empDto");
		EmployeeDto emp = (EmployeeDto) object;
		serviceImpl.deleteAccount(emp);
		return "login";
	}

	// will take you to update emp page
	@GetMapping("/updateProfile")
	public String updateEmpPage(Model model, HttpSession session) {
		// object form seesion
		EmployeeDto emp = (EmployeeDto) session.getAttribute("empDto");
		
		if(emp == null) {
			return "login";
		}
		// send objet to js page
		model.addAttribute("emp", emp);
		return "updateEmpPage";
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	String updateEmployee(@ModelAttribute EmployeeDto empFromJspp, BindingResult result, HttpSession session,
			Model model) {
		// object form session
		EmployeeDto emp = (EmployeeDto) session.getAttribute("empDto");
		
		if(emp == null) {
			return "login";
		}
		
		// whether model has error or not
		if (result.hasErrors()) {
			model.addAttribute("error", result.getFieldError().getField());
			System.out.println(empFromJspp);
			// send objet to js page
			model.addAttribute("emp", emp);
			return "updateEmpPage";
		}

		// updation logic
		empFromJspp.setCompany(emp.getCompany());
		empFromJspp.setDepartment(emp.getDepartment());
		empFromJspp.setRole(emp.getRole());
		empFromJspp.setId(emp.getId());
		serviceImpl.udpateEmp(empFromJspp);
		
		// send to page
		model.addAttribute("emp", empFromJspp);

		// update to session
		model.addAttribute("empDto", empFromJspp);
		return "profilepage";
	}

}
