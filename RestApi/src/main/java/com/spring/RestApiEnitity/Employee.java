package com.spring.RestApiEnitity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries ( {
	@NamedQuery(name="Employee.findAll",query="SELECT e FROM Employee e"),
	@NamedQuery(name="findByEmail",query="SELECT e FROM Employee e WHERE e.email=:pEmail")
	}
	)
public class Employee {
	
	@Id
	private String id;
	
	private String name,city,email;
	private int salary;
	
	
	public Employee() {
		this.id = UUID.randomUUID().toString();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
