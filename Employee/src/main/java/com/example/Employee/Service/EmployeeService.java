package com.example.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public Employee createEmployee(Employee e) {
		return empRepo.save(e);
	}

	public List<Employee> viewEmployee(String id) {
		try {
			return empRepo.findAll();
		} catch (Exception e) {
			System.out.println("Something wrong...");
		}
		return null;
	}

	public String updateEmployee(Employee e) {
		try {
			Employee e1 = empRepo.findById(e.getId()).orElse(null);
			empRepo.delete(e1);
			empRepo.save(e);
			return "Customer details updated successfully.";
		} catch (Exception excep) {
			System.out.println("Please enter correct details");
		}
		return null;
	}

	public String deleteEmployee(String id) {
		for (Employee e : empRepo.findAll()) {
			if (id.equals(e.getId())) {
				empRepo.delete(e);
				return "User deleted successfully";
			}
		}
		return "User Not Found!";
	}
}