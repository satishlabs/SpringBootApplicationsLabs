package com.satishlabs.springjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.satishlabs.springjpademo.entity.Employee;
import com.satishlabs.springjpademo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee saveEmp(Employee emp) {
		return employeeRepo.save(emp);

	}

	public Employee getEmpById(Integer empId) {
		return employeeRepo.findById(empId).get();
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}
	
	public List<Employee> getByEmpName(@PathVariable String empName){
		return employeeRepo.getByEmpName(empName);
	}
}
