package com.example.demo.employeeInfo.entity;

import java.util.List;

public class EmployeesOfDepatment {
	
	int id;
	String dname;
	List<Employee> listOfEmployees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
}
