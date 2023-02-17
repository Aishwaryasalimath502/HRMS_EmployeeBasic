package com.infokalash.spring.employeedetails.service;

import java.util.List;
import java.util.Optional;

import com.infokalash.spring.employeedetails.model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	//List<Employee> getAllemployees(Employee employees);
	List getAllemployees();
	Employee getAllEmployeeById(Long id);
	Employee getAllEmployeeByIdAndFirstName(Long id, String firstName);
	List<Employee> getAllEmployeeByFirstNameAndEmpActiveStatus(String firstName, boolean empActiveStatus);
	
    Optional<Employee> getEmployeeById(Long id);
    
    //To update the data
    Employee updateEmployee(Long id, Employee employee);
	void deleteEmployeeById(Long id);
    
	//Search
	
	
	List<Employee> findByFirstName(String firstName);
	
	//Search by ID
	Employee findById(Long id);


}
