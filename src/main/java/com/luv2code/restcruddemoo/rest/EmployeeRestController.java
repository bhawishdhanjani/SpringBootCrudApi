package com.luv2code.restcruddemoo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.restcruddemoo.entity.Employee;
import com.luv2code.restcruddemoo.service.EmployeeService;
import com.luv2code.restcruddemoo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}




	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findByID(@PathVariable int employeeId){
		Employee employee = employeeService.findByID(employeeId);
		if(employee==null)
			throw new RuntimeException("Employee id not found - "+employeeId);
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		Employee addedEmployee = employeeService.save(employee);
		return addedEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.update(employee);
		return updatedEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findByID(employeeId);
		if(employee==null)
			throw new RuntimeException("Employee does not exit - "+employeeId);
		
		employeeService.deleteById(employeeId);
		
		
		return "Emplooye is deleted " + employeeId;
		
	}
	
	
	
	
	
}
