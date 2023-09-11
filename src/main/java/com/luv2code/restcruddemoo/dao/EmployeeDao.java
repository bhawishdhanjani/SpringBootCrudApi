package com.luv2code.restcruddemoo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.restcruddemoo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
