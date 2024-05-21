package com.example.demo.employeeInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeInfo.entity.DepartmentInfoEntity;
import com.example.demo.employeeInfo.service.DepartmentInfoServiceInterface;

import ch.qos.logback.core.net.SyslogOutputStream;

@RequestMapping("/department")
@RestController
public class DepartmentInfoController {

	@Autowired 
	DepartmentInfoServiceInterface departmentInfoService;
	
	@PostMapping("/Add")
	public DepartmentInfoEntity addDepartment(@RequestBody DepartmentInfoEntity ddet) throws Exception
	{
		System.out.print(ddet.getdHead());
		return departmentInfoService.addDepatmentDetails(ddet);
	}
	
	@PutMapping("/update")
	public DepartmentInfoEntity updateDepartmentDetilails(@RequestBody DepartmentInfoEntity requestData) throws Exception 
	{
		return departmentInfoService.updateDepatmentDetails(requestData);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeDepartmentDetilails(@PathVariable int id) throws Exception
	{
		 departmentInfoService.removeDepatmentDetails(id);
	}
	
		
}
