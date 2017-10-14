package com.spring.EmployeeService;

import java.util.List;

import com.spring.RestApiEnitity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee find(String id);
	public Employee create(Employee emp);
	public Employee update(String id,Employee emp);
	public void delete(String id);
}
