package com.example.demo.employeeInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeInfo.entity.AllDetails;
import com.example.demo.employeeInfo.entity.DepartmentInfoEntity;
import com.example.demo.employeeInfo.entity.Employee;
import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;
import com.example.demo.employeeInfo.entity.EmployeesOfDepatment;
import com.example.demo.employeeInfo.repository.DepartmentInfoRepo;
import com.example.demo.employeeInfo.repository.EmployeeInfoRepo;

@Service
public class EmpDepDetailsCmdService implements EmpDepDetailsCmdServiceInterface {

	@Autowired
	DepartmentInfoRepo departmentInfoRepo;
	@Autowired
	EmployeeInfoRepo employeeInfoRepo;
	
	@Override
	public AllDetails viewAllDetails() throws Exception {
		AllDetails allDetails=new AllDetails();
		try
		{
			List<DepartmentInfoEntity> depInfo=departmentInfoRepo.findAll();
			List<EmployeeInfoEntity> empInfo=employeeInfoRepo.findAll();
			allDetails.setDepInfo(depInfo);
			allDetails.setEmpInfo(empInfo);
		}
		catch(Exception e)
		{
			throw new Exception("Employee Depatment Info Not found");
		}
		return allDetails;
	}

	@Override
	public EmployeesOfDepatment viewemployeesOfDep(int did) throws Exception {
		EmployeesOfDepatment emp=null;
		DepartmentInfoEntity  depDetails = null;
		List<Employee> lemp=new ArrayList<>();
		try
		{
			depDetails=departmentInfoRepo.findById(did).get();
			emp.setId(depDetails.getId());
			emp.setDname(depDetails.getDname());
		}
		catch (Exception e)
		{
			throw new Exception("Depatment Info Not found");
		}
		for(EmployeeInfoEntity empe : employeeInfoRepo.findAll())
		{
			if(depDetails.getDname().equals(empe.getDepartment()))
			{
				Employee emp1=new Employee(empe.getId(),empe.getName());
				lemp.add(emp1);
			}
		}
		emp.setListOfEmployees(lemp);
		return emp;
	}

	@Override
	public List<Employee> viewEmpIdAndName() throws Exception {
		List<Employee> emp=new ArrayList<>();
		for(EmployeeInfoEntity empInfo: employeeInfoRepo.findAll())
		{
			Employee emp1=new Employee(empInfo.getId(),empInfo.getName());
			emp.add(emp1);
		}
		return emp;
	}

}
