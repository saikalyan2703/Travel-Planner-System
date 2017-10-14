package com.spring.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.EmployeeService.EmployeeService;
import com.spring.RestApiEnitity.Employee;

//@Component @controller and @RestController is a mvc component
@RestController
@ResponseBody 
@RequestMapping (value="/employees") //used alternatively for redundancy
public class EmpContr {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(method=RequestMethod.GET) //or value="employees"
	public List<Employee> FindAll() {
		return service.findAll();		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")		
	public Employee Find(@PathVariable("id") String id) {
		return service.find(id);			
		}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public Employee Update(@PathVariable("id") String id, Employee emp) {
		return service.update(id, emp);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void Delete(@PathVariable("id") String id) {	
		service.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee Create(@RequestBody Employee emp) {
		return service.create(emp);
	}

}
