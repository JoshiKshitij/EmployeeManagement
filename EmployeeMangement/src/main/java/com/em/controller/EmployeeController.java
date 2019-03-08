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
import org.springframework.web.bind.annotation.CookieValue;
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
	EmployeeServiceInterface serviceImpl;

	Logger logger = Logger.getLogger(EmployeeController.class);

	@GetMapping("/")
	public String index(Model model) {
		// model.addAttribute("index", "Model test is working");
		return "login";
	}

	@GetMapping("/saveEmpPage")
	public String saveEmpPage() {
		return "saveEmp";
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
	// @RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
	public String login(@RequestParam String loginId, @RequestParam String password, Model model) {

		EmployeeDto empFromDb = serviceImpl.getEmpByLoginId(loginId);

		// this line will bind the object to the session
		model.addAttribute("empDto", empFromDb);
		// model.addAttribute("test", "testvalue");

		if (password.equals(empFromDb.getPassword())) {
			if (empFromDb.getRole().equals("admin")) {
				model.addAttribute("welcome",
						"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());

				return "adminpage";
			}
			if (empFromDb.getRole().equals("user")) {
				model.addAttribute("welcome",
						"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());
				return "userpage";
			}
		}
		return "login";
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
		// send objet to js page
		model.addAttribute("emp", emp);
		return "updateEmpPage";
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	String updateEmployee(@ModelAttribute EmployeeDto empFromJspp, BindingResult result, HttpSession session,
			Model model) {
		// object form session
		EmployeeDto emp = (EmployeeDto) session.getAttribute("empDto");

		// whether model has error or not
		if (result.hasErrors()) {
			model.addAttribute("error", result.getFieldError().getField());
			System.out.println(empFromJspp);
			// send objet to js page
			model.addAttribute("emp", emp);

			return "updateEmpPage";
		}

		System.out.println(empFromJspp);
		// updation logic
		empFromJspp.setCompany(emp.getCompany());
		empFromJspp.setDepartment(emp.getDepartment());
		empFromJspp.setRole(emp.getRole());
		empFromJspp.setId(emp.getId());
		serviceImpl.udpateEmp(empFromJspp);

		return "profilePage";
	}

}
