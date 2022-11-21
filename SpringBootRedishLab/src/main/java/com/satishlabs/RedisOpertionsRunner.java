package com.satishlabs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisOpertionsRunner implements CommandLineRunner{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void run(String... args) throws Exception {
		
		//save one employee
		employeeDAO.saveEmployee(new Employee(500, "Emp-0", 2504.0));
		
		//saving multiple employees
		employeeDAO.saveAllEmployee(
				Map.of(501,new Employee(501, "Emp-1", 2369.0),
						502, new Employee(502, "Emp-2", 1344.6),
						503,new Employee(503, "Emp-4", 4560.0))
				);
		
		//Modifying employee with empId 503
		employeeDAO.updateEmployee(new Employee(503, "Emp-3", 2345.7));
		
		//deleting employee with empId 500
		employeeDAO.deleteEmployee(500);
		
		//retriving all employees
		employeeDAO.getAllEmployees().forEach((k,v)->System.out.println(k+" : "+v));
		
		//retriving employee with empId 501
		System.out.println("Employee details for 501 : "+employeeDAO.getOneEmployee(501));
	}

}
