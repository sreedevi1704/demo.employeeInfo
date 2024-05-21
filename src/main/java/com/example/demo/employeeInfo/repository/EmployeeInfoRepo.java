package com.example.demo.employeeInfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.employeeInfo.entity.EmployeeInfoEntity;

@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfoEntity,Integer>{
	Optional<EmployeeInfoEntity> findByDepartment(String department);
	
	 @Query("SELECT e.name FROM EmployeeInfoEntity e")
	 List<String> findAllEmployeeNames();
}
