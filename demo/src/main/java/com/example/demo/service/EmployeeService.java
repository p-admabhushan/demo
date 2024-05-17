package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
	
	void deleteEmployee(Long id);
	
	

}
