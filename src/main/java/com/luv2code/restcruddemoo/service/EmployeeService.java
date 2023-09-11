package com.luv2code.restcruddemoo.service;

import java.util.List;

import com.luv2code.restcruddemoo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findByID(int id);
	Employee update(Employee employee);
	Employee save(Employee employee);
	void deleteById(int id);
	
}
