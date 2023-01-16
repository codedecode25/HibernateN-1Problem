package com.codedecode.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.demo.custom.exception.BusinessException;
import com.codedecode.demo.custom.exception.ControllerException;
import com.codedecode.demo.entity.Department;
import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<?> fetchEmployeeById(@PathVariable("empid") Long empidL){
		try {
			return new ResponseEntity<Employee>(employeeServiceInterface.getEmpById(empidL),HttpStatus.OK);
		}catch (Exception e) {
			ControllerException controllerException = new ControllerException( e.getMessage() + "  " + e.getCause());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/dep")
	public ResponseEntity<?> fetchAllDepartments(){
		try {
			return new ResponseEntity<List<Department>>(employeeServiceInterface.getAllDepartmets(),HttpStatus.OK);
		}catch (Exception e) {
			ControllerException controllerException = new ControllerException( e.getMessage() + "  " + e.getCause());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	

	
	
}
