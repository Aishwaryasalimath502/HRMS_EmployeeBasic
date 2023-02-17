package com.infokalash.spring.employeedetails.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infokalash.spring.employeedetails.model.Employee;
import com.infokalash.spring.employeedetails.repository.EmployeeRepository;
import com.infokalash.spring.employeedetails.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public ResponseEntity<Employee> addemployee(@RequestBody Employee employee){
		Employee emp = employeeService.createEmployee(employee);
		return new  ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get_details")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List employees = employeeService.getAllemployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	
	}
	
//	@GetMapping("/get/{id}")
//	public ResponseEntity<List<Employee>> getAllEmployeeById(@PathVariable Long id){
//		Employee empl = employeeService.getAllEmployeeById(id);
//		return new ResponseEntity (empl, HttpStatus.OK);
//	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable Long id){
		Employee employee = employeeService.getAllEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	//getting data from 2 attributes
	@GetMapping("/get_data/{id}/{firstName}")
	public ResponseEntity<Employee> getAllEmployeeByIdAndFirstName(@PathVariable Long id, @PathVariable String firstName){
		Employee employee1 = employeeService.getAllEmployeeByIdAndFirstName(id, firstName);
		return new ResponseEntity<>(employee1, HttpStatus.OK);
	}
	
	@GetMapping("/get_info/{firstName}/{empActiveStatus}")
	public ResponseEntity<List<Employee>> getAllEmployeeByFirstNameAndEmpActiveStatus(@PathVariable String firstName, @PathVariable boolean empActiveStatus) {
	    List<Employee> employees = employeeService.getAllEmployeeByFirstNameAndEmpActiveStatus(firstName, empActiveStatus);
	    return new ResponseEntity<>(employees, HttpStatus.OK);
	}	
	
	
	//Update the Employee Details
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	    Employee existingEmployee = employeeRepository.findById(id).orElse(null);
	    if (existingEmployee != null) {
	        existingEmployee.setFirstName(employee.getFirstName());
	        existingEmployee.setMiddleName(employee.getMiddleName());
	        existingEmployee.setLastName(employee.getLastName());
	        existingEmployee.setAge(employee.getAge());
	        existingEmployee.setGender(employee.getGender());
	        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
	        existingEmployee.setDateOfJoining(employee.getDateOfJoining());
	        existingEmployee.setLastTxId(employee.getLastTxId());
	        existingEmployee.setLastUpdatedUser(employee.getLastUpdatedUser());
	        existingEmployee.setEmpActiveStatus(employee.isEmpActiveStatus());
	        existingEmployee.setEmaliId(employee.getEmaliId());
	        Employee updatedEmployee = employeeRepository.save(existingEmployee);
	        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@DeleteMapping("/delete_data/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id){
		employeeService.deleteEmployeeById(id);
		//return ResponseEntity.noContent().build();
		return new ResponseEntity("Employee with ID " + id + " has been deleted ", HttpStatus.OK);
	
	}
	
    @GetMapping("/search/{firstName}")
    public ResponseEntity<List<Employee>> searchEmployeeByFirstName(@PathVariable String firstName) {
        List<Employee> employee = employeeService.findByFirstName(firstName); 
    	if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }
    
    @GetMapping("/search_id/{id}")
    public ResponseEntity <Employee>searchById(@PathVariable Long id) {
        Employee employee1 = employeeService.findById(id); 
    	if (employee1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee1);
        }
    }
	



}
