package com.infokalash.spring.employeedetails.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.infokalash.spring.employeedetails.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    	
	Employee getAllEmployeeByIdAndFirstName(Long id, String firstName);


	List<Employee> findByFirstName(String firstName);

	List<Employee> findAll();	
	

	
}

