package com.example.demo.employeeInfo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;
import com.example.demo.employeeInfo.service.EmployeeInfoServiceInterface;

@RequestMapping("/employee")
@RestController
public class EmployeeInfoController {

	@Autowired 
	EmployeeInfoServiceInterface empployeeInfoService;
	
	@PostMapping("/add")
	public EmployeeInfoEntity addEmployee(@RequestBody EmployeeInfoEntity empdet) throws Exception
	{
		return empployeeInfoService.addEmployee(empdet);
	}
	
	@PutMapping("/update")
	public EmployeeInfoEntity updateEmployee(@RequestBody EmployeeInfoEntity requestData) throws Exception {
		EmployeeInfoEntity updated=empployeeInfoService.updateEmployee(requestData);
		return updated;
	}
	
	@PatchMapping("updateDep/{id}")
	public EmployeeInfoEntity update(@PathVariable int id,@RequestBody EmployeeInfoEntity requestData) throws Exception
	{
		EmployeeInfoEntity employeeDetails = empployeeInfoService.findById(id);
		employeeDetails.setDepartment(requestData.getDepartment());
		return empployeeInfoService.updateEmployee(employeeDetails);
	}
}
