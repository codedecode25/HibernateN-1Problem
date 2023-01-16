package com.codedecode.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.codedecode.demo.entity.Department;
import com.codedecode.demo.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee getEmpById(Long empidL);

	public List<Department> getAllDepartmets();


}
