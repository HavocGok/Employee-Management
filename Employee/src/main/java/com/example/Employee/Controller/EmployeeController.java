package com.example.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.EmployeeService;

@RestController
@RequestMapping("/EmployeeApi")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addNew")
	public Employee addEmployee(Employee e) {
		return empService.createEmployee(e);
	}

	@GetMapping("/viewEmployee")
	public List<Employee> viewCustomer(String id) {
		return empService.viewEmployee(id);
	}
	
	@PutMapping("/EditEmployee")
	public String editEmployee(Employee e) {
		return empService.updateEmployee(e);
	}
	
	@DeleteMapping("/deleteEmployee")
	public String removeEmployee(String id) {
		return empService.deleteEmployee(id);
	}
	
}
