package com.luv2code.restcruddemoo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.restcruddemoo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
	
		this.entityManager = entityManager;
	}



	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("FROM employee",Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findByID(int id) {
		Employee employee = entityManager.find(Employee.class,id);
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		Employee updatedEmployee = entityManager.merge(employee);
		return updatedEmployee;
	}

	@Override
	public Employee save(Employee employee) {
		Employee daoEmployee = entityManager.merge(employee);
		return daoEmployee;
	}

	@Override
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}
	

}
