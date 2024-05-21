package com.example.demo.employeeInfo.service;

import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;

public interface EmployeeInfoServiceInterface {

	EmployeeInfoEntity addEmployee(EmployeeInfoEntity empdet) throws Exception;

	EmployeeInfoEntity updateEmployee(EmployeeInfoEntity requestData) throws Exception;

	EmployeeInfoEntity findById(int id) throws Exception;

}
