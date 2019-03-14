package com.em.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class EmpAdminController {

	@Autowired
	EmployeeServiceInterface serviceInterface;

	// will take to save page
	@GetMapping("/saveEmpPage")
	public String saveEmpPage() {
		return "saveEmp";
	}

	// it will recieve form data
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	String saveEmployee(@ModelAttribute EmployeeDto employee, 
			BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "saveEmp";
		}

		System.out.println(employee);
		EmployeeDto empAdmin = (EmployeeDto) session.getAttribute("empDto");

		employee.setCompany(empAdmin.getCompany());
		employee.setDepartment(empAdmin.getDepartment());

		long id = (Long) serviceInterface.saveEmpInDb(employee);

		if (id > 0) {
			model.addAttribute("info",
					"emp created with login id ="
					+ " " + employee.getLoginId() + 
					" with passwrd " +
					empAdmin.getPassword());
			return "saveEmp";
		}
		return "employeeDetails";
	}

}
