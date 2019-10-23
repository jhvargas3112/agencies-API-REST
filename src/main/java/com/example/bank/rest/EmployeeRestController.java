package com.example.bank.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.bank.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.example.bank.model.Employee;

@RestController
public class EmployeeRestController {
	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value = "/bank/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@GetMapping(value = "/bank/employee/by_employee_code/{employee_code}")
	public ResponseEntity<Employee> getEmployeeByEmployeeCode(@PathVariable(value = "employee_code", required = true) Integer employeeCode) {
		return ResponseEntity.ok(employeeService.findByEmployeeCode(employeeCode));
	}
}
