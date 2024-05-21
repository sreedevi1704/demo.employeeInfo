package com.example.demo.employeeInfo.entity;

import java.util.List;

public class AllDetails {
	
	private int id;
	private List<DepartmentInfoEntity> depInfo;
	private List<EmployeeInfoEntity> empInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<DepartmentInfoEntity> getDepInfo() {
		return depInfo;
	}
	public void setDepInfo(List<DepartmentInfoEntity> depInfo) {
		this.depInfo = depInfo;
	}
	public List<EmployeeInfoEntity> getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(List<EmployeeInfoEntity> empInfo) {
		this.empInfo = empInfo;
	}
	
}
