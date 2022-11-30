package com.satishlabs.springjpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.springjpademo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> getByEmpName(String empName);
}
