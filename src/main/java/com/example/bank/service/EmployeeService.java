package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findByEmployeeCode(Integer employeeCode);
}
