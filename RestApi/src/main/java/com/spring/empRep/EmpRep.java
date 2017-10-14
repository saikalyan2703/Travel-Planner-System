package com.spring.empRep;

import java.util.List;

import com.spring.RestApiEnitity.Employee;

public interface EmpRep {
	public List<Employee> findAll();
	public Employee find(String id);
	public Employee create(Employee emp);
	public Employee update(Employee emp);
	public void delete(Employee emp);
	public Employee findbyEmail(String id);
}
