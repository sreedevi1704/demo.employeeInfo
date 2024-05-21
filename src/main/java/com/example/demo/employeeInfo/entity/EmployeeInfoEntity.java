package com.example.demo.employeeInfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class EmployeeInfoEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String dob;
	@NotNull
	@NotBlank
	private String salary;
	@NotNull
	@NotBlank
	private String department;
	@NotNull
	@NotBlank
	private String address;
	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String dateOfJoin;
	
	private String bonusPercentage;
	
	private String repManager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public String getBonusPercentage() {
		return bonusPercentage;
	}
	public void setBonusPercentage(String bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}
	public String getRepManager() {
		return repManager;
	}
	public void setRepManager(String repManager) {
		this.repManager = repManager;
	}
	
}
