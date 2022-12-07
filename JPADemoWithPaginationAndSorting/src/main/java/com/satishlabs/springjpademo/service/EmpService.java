package com.satishlabs.springjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.satishlabs.springjpademo.entity.Employee;
import com.satishlabs.springjpademo.repo.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo empRepo;

	public Employee saveEmpData(Employee emp) {
		return empRepo.save(emp);
	}

	public Employee getById(Integer empId) {
		return empRepo.findById(empId).get();
	}

	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	public List<Employee> getAllEmpPageSize(int pageNo, int recordCount) {
		Pageable pageable = PageRequest.of(pageNo, recordCount, Sort.by("empName"));
		return empRepo.findAll(pageable).get().toList();
	}

	public List<Employee> getByEmpName(String empName) {
		return empRepo.getByEmpName(empName);
	}

	public List<Employee> getByEmpNamePageSize(String empName, int pageNo, int recordCount) {
		Pageable pageable = PageRequest.of(pageNo, recordCount, Sort.by("empAge"));
		return empRepo.getByEmpNamePageSize(empName, pageable);
	}
}
