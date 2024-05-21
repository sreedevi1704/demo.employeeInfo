package com.example.demo.employeeInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeInfo.entity.AllDetails;
import com.example.demo.employeeInfo.entity.Employee;
import com.example.demo.employeeInfo.entity.EmployeesOfDepatment;
import com.example.demo.employeeInfo.service.EmpDepDetailsCmdServiceInterface;
//http://localhost:8787/swagger-ui/index.html#/ -->url
@RequestMapping("/empdepdetails")
@RestController
public class EmpDepDetailsCmdController {
	@Autowired
	EmpDepDetailsCmdServiceInterface empDepDetailsCmdService;
	
	@GetMapping("/viewAllDetails")
	public AllDetails viewAllDetails() throws Exception{
		return empDepDetailsCmdService.viewAllDetails();
	}
	
	@GetMapping("/{id}")
	public EmployeesOfDepatment viewemployeesOfDep(@PathVariable int id,@RequestParam(value = "expand", required = false) String expand) throws Exception{
		if ("employee".equals(expand)) {
			 return  empDepDetailsCmdService.viewemployeesOfDep(id);
	        }
		else
		{
			throw new Exception("Invalid expand value in Request");
		}
	}
	
	@GetMapping
	public List<Employee> getEmployees(@RequestParam(value = "lookup", required = false) boolean val) throws Exception{
		if (Boolean.TRUE.equals(val)) {
			 return  empDepDetailsCmdService.viewEmpIdAndName();
	        }
		else
		{
			throw new Exception("Invalid Lookup value in Request");
		}
	}

}
