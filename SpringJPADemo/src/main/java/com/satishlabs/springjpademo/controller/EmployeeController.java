package com.satishlabs.springjpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.springjpademo.entity.Employee;
import com.satishlabs.springjpademo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveemp")
	public Employee saveEmpDate(@RequestBody Employee emp) {
		return employeeService.saveEmp(emp);
	}
	
	@GetMapping("/get/{empId}")
	public Employee getEmpById(@PathVariable Integer empId) {
		return employeeService.getEmpById(empId);
	}
	
	@GetMapping("/getallemp")
	public List<Employee> getAllEmployees(){
		List<Employee> empList = employeeService.getAllEmployee();
		return empList;
	}
	@GetMapping("/getempname/{empName}")
	public List<Employee> getByEmpName(@PathVariable String empName) {
		return employeeService.getByEmpName(empName);
	}
}
