package com.infokalash.spring.employeedetails.model;

import java.sql.Date;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Employee_Information")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "First_name")
	private String firstName;
	
	@Column(name = "Middle_Name")
	private String middleName;
	
	@Column(name = "Last_name")
	private String lastName;
	
	@Email(message = "Invalid email format")
	@Pattern(regexp = ".*@infokalash\\.com$", message = "Email must contain the @infokalash.com domain")
	@Column(name = "Email")
	private String emaliId;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Date_of_Birth")
	private Date dateOfBirth;
	
	@Column(name = "Date_of_Joining")
	private Date dateOfJoining;
	
	@Column(name = "Emp_Active_Status")
	private boolean empActiveStatus;
	
	@Nonnull
	@Column(name = "Last_Updated_User")
	private String lastUpdatedUser;
	
	@Column(name = "Last_Tx_Id")
	private int lastTxId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public boolean isEmpActiveStatus() {
		return empActiveStatus;
	}

	public void setEmpActiveStatus(boolean empActiveStatus) {
		this.empActiveStatus = empActiveStatus;
	}

	

	public String getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public int getLastTxId() {
		return lastTxId;
	}

	public void setLastTxId(int lastTxId) {
		this.lastTxId = lastTxId;
	}

	public String getEmaliId() {
		return emaliId;
	}

	public void setEmaliId(String emaliId) {
		this.emaliId = emaliId;
	}
	
	public List<Employee> searchById(Long id){
		return null;
	}

	

	
	
	
}
