package com.spring.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Exceptions.BadReq;
import com.spring.Exceptions.EntityExcep;
import com.spring.RestApiEnitity.Employee;
import com.spring.empRep.EmpRep;

//@Component Service is component
@Service
@Transactional
public class EmpSerImp implements EmployeeService {
	
	@Autowired
	public EmpRep repository;

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public Employee find(String id) {
		Employee emp=repository.find(id);
		if(emp==null) {
			throw new EntityExcep("Employee Not Found");
		}
		return emp;
	}

	public Employee create(Employee emp) {
		Employee exists=repository.findbyEmail(emp.getId());
		if(exists!=null) {
			throw new BadReq("Employee Already exists");
		}
		return repository.create(emp);
	}

	public Employee update(String id, Employee emp) {
		Employee exists=repository.find(id);
		if(exists==null) {
			throw new EntityExcep("Employee Not Found");
		}
		return repository.update(emp);
	}

	public void delete(String id) {
		Employee exists=repository.find(id);
		if(exists==null) {
			throw new EntityExcep("Employee Not Found");
		}
		 repository.delete(exists);
	}

}
