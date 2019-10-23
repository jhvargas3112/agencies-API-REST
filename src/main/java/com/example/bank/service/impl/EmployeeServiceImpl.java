package com.example.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bank.model.Employee;
import com.example.bank.repository.EmployeeRepository;
import com.example.bank.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByEmployeeCode(Integer employeeCode) {
		Optional<Employee> employee = employeeRepository.findById(employeeCode);
		
		return employee.isPresent() ? employee.get() : null;
	}
}
