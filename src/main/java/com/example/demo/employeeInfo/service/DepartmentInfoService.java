package com.example.demo.employeeInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeInfo.entity.DepartmentInfoEntity;
import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;
import com.example.demo.employeeInfo.repository.DepartmentInfoRepo;
import com.example.demo.employeeInfo.repository.EmployeeInfoRepo;

@Service
public class DepartmentInfoService implements DepartmentInfoServiceInterface {

	@Autowired
	DepartmentInfoRepo departmentInfoRepo;
	@Autowired
	EmployeeInfoRepo employeeInfoRepo;
	@Autowired
	EmpDepValidations validator;
	
	@Override
	public DepartmentInfoEntity addDepatmentDetails(DepartmentInfoEntity ddet) throws Exception{
		if( ddet.getdHead()!=null && ddet.getdHead().length()==0)
		{
			validator.hodCheck(ddet.getdHead());
		}
		departmentInfoRepo.saveAndFlush(ddet);
		return ddet;
	}

	@Override
	public DepartmentInfoEntity updateDepatmentDetails(DepartmentInfoEntity requestData) throws Exception{
		return departmentInfoRepo.save(requestData);
	}

	@Override
	public DepartmentInfoEntity removeDepatmentDetails(int id) throws Exception{
		DepartmentInfoEntity  bean = null;
		try {
			bean = departmentInfoRepo.findById(id).get();
		}
		catch(Exception e) {
			throw new Exception("Department details not found!");
		}
		String department=bean.getDname();
		Optional<EmployeeInfoEntity> entity=employeeInfoRepo.findByDepartment(department); 
		 if(entity == null || entity.isEmpty()) 
			  departmentInfoRepo.deleteById(id);
		 else 
			  throw new Exception("Deletion not possible, Department assigned to employee");
		 
		return bean;
	}

}
