package com.example.demo.employeeInfo.service;

import com.example.demo.employeeInfo.entity.DepartmentInfoEntity;

public interface DepartmentInfoServiceInterface {

	DepartmentInfoEntity addDepatmentDetails(DepartmentInfoEntity ddet) throws Exception;

	DepartmentInfoEntity updateDepatmentDetails(DepartmentInfoEntity requestData) throws Exception;

	DepartmentInfoEntity removeDepatmentDetails(int id) throws Exception;

}
