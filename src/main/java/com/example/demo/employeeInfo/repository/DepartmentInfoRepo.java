package com.example.demo.employeeInfo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employeeInfo.entity.DepartmentInfoEntity;

@Repository
public interface DepartmentInfoRepo extends JpaRepository<DepartmentInfoEntity,Integer>{
}
