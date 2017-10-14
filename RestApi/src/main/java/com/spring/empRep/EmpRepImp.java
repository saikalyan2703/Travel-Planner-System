package com.spring.empRep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.RestApiEnitity.Employee;

@Repository
public class EmpRepImp implements EmpRep {
	
	// to use transactions 
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public EmpRep repository;

	public List<Employee> findAll() {
		TypedQuery<Employee> query=em.createQuery("SELECT e FROM Employee e",Employee.class);
		//TypedQuery<Employee> query=em.createNamedQuery("findAll",Employee.class);
		return query.getResultList();
	}

	public Employee find(String id) {
		Employee ees = em.find(Employee.class,id);
		return ees;
	}

	public Employee create(Employee emp) {
		em.persist(emp);
		return emp;
	}

	public Employee update(Employee emp) {
		return em.merge(emp);
	}

	public void delete(Employee emp) {
		//Employee ees = em.find(Employee.class,id);
		em.remove(emp);
	}

	public Employee findbyEmail(String id) {
		TypedQuery<Employee> query=em.createNamedQuery("findByEmail",Employee.class);
		query.setParameter("pEmail", "kvk.com");
		List<Employee> em= query.getResultList();
		if(em!=null&&em.size()==1) {
			return em.get(0);
		}
		else {
			return null;	
		}		
	}

}
