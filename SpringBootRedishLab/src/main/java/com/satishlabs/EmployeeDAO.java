package com.satishlabs;

import java.util.Map;

public interface EmployeeDAO {
	public void saveEmployee(Employee emp);
	public Employee getOneEmployee(Integer id);
	public void updateEmployee(Employee emp);
	public Map<Integer, Employee> getAllEmployees();
	public void deleteEmployee(Integer id);
	public void saveAllEmployee(Map<Integer, Employee> map);
}
