package com.satishlabs.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
