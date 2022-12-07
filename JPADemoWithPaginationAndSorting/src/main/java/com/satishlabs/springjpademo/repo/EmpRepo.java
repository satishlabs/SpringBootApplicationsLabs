package com.satishlabs.springjpademo.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.springjpademo.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

	public List<Employee> getByEmpName(String empName);
	
	public List<Employee> getByEmpNamePageSize(String empName,Pageable pageable);

}
