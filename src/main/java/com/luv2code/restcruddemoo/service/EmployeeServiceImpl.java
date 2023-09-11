package com.luv2code.restcruddemoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.restcruddemoo.dao.EmployeeDao;

import com.luv2code.restcruddemoo.entity.Employee;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee findByID(int id) {
		return employeeDao.findByID(id);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		
		return employeeDao.update(employee);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
		
	}
	

}
