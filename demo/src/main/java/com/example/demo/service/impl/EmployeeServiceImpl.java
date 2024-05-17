package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
@Override
public EmployeeDto createEmployee(EmployeeDto employeeDto) {
	// TODO Auto-generated method stub
	Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	Employee savedEmployee = employeeRepository.save(employee);
	return EmployeeMapper.mapToEmployeeDto(savedEmployee);
}
@Override
public EmployeeDto getEmployeeById(Long employeeId) {
	// TODO Auto-generated method stub
	Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with a given id : "+employeeId));
	
	return EmployeeMapper.mapToEmployeeDto(employee);
}
@Override
public List<EmployeeDto> getAllEmployees() {
	// TODO Auto-generated method stub
	List<Employee> allEmployees = employeeRepository.findAll();
	
	return allEmployees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
}
@Override
public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
	// TODO Auto-generated method stub
	
	Employee updateEmp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with a given id : "+id));
	updateEmp.setFirstName(employeeDto.getFirstName());
	updateEmp.setLastName(employeeDto.getLastName());
	updateEmp.setEmail(employeeDto.getEmail());
	return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(updateEmp));
	
	
}
@Override
public void deleteEmployee(Long employeeId) {
	
	// TODO Auto-generated method stub
	Employee removeEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with a given id : "+employeeId));
	employeeRepository.delete(removeEmployee);
	
    }
}
