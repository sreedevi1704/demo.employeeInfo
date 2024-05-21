package com.example.demo.employeeInfo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;
import com.example.demo.employeeInfo.repository.EmployeeInfoRepo;

@Component
public class EmpDepValidations {

	@Autowired
	EmployeeInfoRepo employeeInfoRepo;
	
	public void createValidation(EmployeeInfoEntity empdet) throws Exception
	{
		if(!("VP".equals(empdet.getTitle())))
		{
			if(empdet.getRepManager()==null || empdet.getRepManager().length()==0)
				throw new Exception("Reporting Manager is mandatory");
			List<EmployeeInfoEntity> emplist=employeeInfoRepo.findAll();
			for(EmployeeInfoEntity emp: emplist)
			{
				if(emp.getName().equals(empdet.getName()))
					return;
			}
			throw new Exception("Invalid reporting manager");
		}
	}
	public boolean dateCheck(String date)
	{
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 try {
	            LocalDate date1 = LocalDate.parse(date, dateFormatter);
	            return false;
	        } catch (DateTimeParseException e) {
	            return true;
	        }
	}
	public boolean bonusValidation(String bonus)
	{
		final String decimalPattern = "^[+-]?(0|[1-9]\\d*)(\\.\\d+)?$";
		Pattern pattern = Pattern.compile(decimalPattern);
        Matcher matcher = pattern.matcher(bonus);
        return matcher.matches();
	}
	public void hodCheck(String hod) throws Exception
	{
		List<String> emplist=employeeInfoRepo.findAllEmployeeNames();
		if(emplist.contains(hod))
				return;
		throw new Exception("Invalid HOD details");
	}
}
