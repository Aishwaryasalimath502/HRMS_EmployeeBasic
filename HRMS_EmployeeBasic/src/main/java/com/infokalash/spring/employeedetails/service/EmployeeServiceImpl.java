package com.infokalash.spring.employeedetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infokalash.spring.employeedetails.model.Employee;
import com.infokalash.spring.employeedetails.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	private Long id;

	
	//Create constructor for the Repository class
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllemployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getAllEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}


	@Override
	public Employee getAllEmployeeByIdAndFirstName(Long id, String firstName) {
		return employeeRepository.getAllEmployeeByIdAndFirstName(id, firstName);
	}


	
	//Implementing a service for update method

	@Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setMiddleName(employee.getMiddleName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            existingEmployee.setDateOfJoining(employee.getDateOfJoining());
            existingEmployee.setLastTxId(employee.getLastTxId());
            existingEmployee.setEmpActiveStatus(employee.isEmpActiveStatus());
            existingEmployee.setEmaliId(employee.getEmaliId());
            existingEmployee.setLastUpdatedUser(employee.getLastUpdatedUser());
            return employeeRepository.save(existingEmployee);
        }
		return employee; 
        }


	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}


	@Override
	public List<Employee> getAllEmployeeByFirstNameAndEmpActiveStatus(String firstName, boolean empActiveStatus) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> findByFirstName(String firstName) {
	        return employeeRepository.findByFirstName(firstName);
	    }

	//Search by Id

	@Override
	public Employee findById(Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		return employeeOptional.orElse(null);
	}


	
}
