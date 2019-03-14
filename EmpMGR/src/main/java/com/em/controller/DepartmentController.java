package com.em.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.em.dto.DepartmentDto;
import com.em.dto.EmployeeDto;
import com.em.service.DepartmentServiceInterface;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentServiceInterface service;
	
	// willl display page 
	@RequestMapping("savedeptPage")
	public String saveDeptPage() {
		return "savedeptPage";
	}
	
	@RequestMapping(name = "savedept", method= RequestMethod.POST )
	public String saveDept(@ModelAttribute DepartmentDto dept , HttpSession session , Model model) {
		
		EmployeeDto deptAdmin = (EmployeeDto)session.getAttribute("empDto");
		
		dept.setComp(deptAdmin.getCompany());
		
		model.addAttribute("dept", dept.getName() + " is saved ");
		service.saveDeptInDb(dept);
		
		return "savedeptPage";
	}
			
}
