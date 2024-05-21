package com.example.demo.employeeInfo.entity;

public class Employee {
	private int eid;
	private String ename;
	
	public Employee(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int i) {
		this.eid = i;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
		
}
