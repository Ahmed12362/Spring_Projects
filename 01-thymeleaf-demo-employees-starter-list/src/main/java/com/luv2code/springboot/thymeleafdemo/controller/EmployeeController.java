package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeService employeeService;
	@Autowired  //Optional For One Constructor
	EmployeeController(EmployeeService employeeService){
		 this.employeeService = employeeService;
	}
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// add to the spring model
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("employee",new Employee());
		return "employees/add-Employee";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("employee")Employee employee){
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id , Model theModel){
		Employee employee = employeeService.findById(id);
		theModel.addAttribute("theEmployee",employee);
		return "employees/update-employee";
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id){
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}