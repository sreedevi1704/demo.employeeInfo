package com.example.demo.employeeInfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;
import com.example.demo.employeeInfo.repository.EmployeeInfoRepo;

@Service
public class EmployeeInfoService implements EmployeeInfoServiceInterface {

	@Autowired
	EmployeeInfoRepo employeeInfoRepo;
	
	
	
	@Override
	public EmployeeInfoEntity addEmployee(EmployeeInfoEntity empdet) throws Exception{
		EmpDepValidations empDepValidations=new EmpDepValidations();
		if(empDepValidations.dateCheck(empdet.getDob()) || empDepValidations.dateCheck(empdet.getDateOfJoin()))
			throw new Exception("Dates should be yyyy-MM-dd format");
		if(!empDepValidations.bonusValidation(empdet.getBonusPercentage()))
			throw new Exception("Invalid bonus Value");
		empDepValidations.createValidation(empdet);
		employeeInfoRepo.saveAndFlush(empdet);
		return empdet;
	}

	@Override
	public EmployeeInfoEntity updateEmployee(EmployeeInfoEntity requestData) throws Exception{
		employeeInfoRepo.save(requestData);
		return requestData;
	}

	@Override
	public EmployeeInfoEntity findById(int id) throws Exception {
		EmployeeInfoEntity empDetails=null;
		try
		{
			empDetails=employeeInfoRepo.findById(id).get();
		}
		catch(Exception e)
		{
			throw new Exception("Employee details not found!");
		}
		return empDetails;
	}
}
