package com.example.demo.employeeInfo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
public class DepartmentInfoEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotBlank
	private String dname;
	@NotNull
	private String creationdate; 
	
	private String dHead;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getdHead() {
		return dHead;
	}
	public void setdHead(String dHead) {
		this.dHead = dHead;
	}
}
