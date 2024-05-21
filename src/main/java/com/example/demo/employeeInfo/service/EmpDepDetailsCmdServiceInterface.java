package com.example.demo.employeeInfo.service;

import java.util.List;

import com.example.demo.employeeInfo.entity.AllDetails;
import com.example.demo.employeeInfo.entity.Employee;
import com.example.demo.employeeInfo.entity.EmployeesOfDepatment;

public interface EmpDepDetailsCmdServiceInterface {

	public AllDetails viewAllDetails() throws Exception;
	
	public EmployeesOfDepatment viewemployeesOfDep(int did) throws Exception;
	
	public List<Employee> viewEmpIdAndName() throws Exception;

}
