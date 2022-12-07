package com.satishlabs.springjpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.springjpademo.entity.Employee;
import com.satishlabs.springjpademo.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@PostMapping("/save")
	public Employee saveEmpData(@RequestBody Employee employee) {
		return empService.saveEmpData(employee);
	}
	
	@GetMapping("/get/{empId}")
	public Employee getById(@PathVariable Integer empId) {
		return empService.getById(empId);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp(){
		return empService.getAllEmp();
	}
	
	@GetMapping("/getAllEmp/{pageNo}/{recordCount}")
	public List<Employee> getAllEmpOnPageSize(@PathVariable int pageNo,@PathVariable int recordCount){
		return empService.getAllEmpPageSize(pageNo, recordCount);
	}
	
	@GetMapping("/getByEmpName/{empName}")
	public List<Employee> getByEmpName(@PathVariable String empName){
		return empService.getByEmpName(empName);
	}
	
	@GetMapping("/getByEmpName/{empName}/{pageNo}/{recordCount}")
	public List<Employee> getByEmpNameOnPageSize(@PathVariable String empName,@PathVariable int pageNo,@PathVariable int recordCount){
		return empService.getByEmpNamePageSize(empName, pageNo, recordCount);
	}
}
