package com.javarticle.spring.rest;

import java.util.Collection;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTControllerExample {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Employees getEmployees() {
		return new Employees();
	}
	@RequestMapping(value = "/api/search", method = RequestMethod.POST)
	public Employees getEmployeesPost() {
		return new Employees();
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public Collection<Employee> getEmployeeNames() {
		return EmployeeSource.getEmployees();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee addStudent(@RequestParam(value = "age") int age,
			@RequestParam(value = "name", defaultValue = "unknown") String name) {
		System.out.println(">>> add employee");
		Employee employee = new Employee();
		employee.setId(UUID.randomUUID().toString());
		employee.setAge(age);
		employee.setName(name);
		EmployeeSource.EMPLOYEES.put(employee.getId(), employee);
		return employee;

	}
}
