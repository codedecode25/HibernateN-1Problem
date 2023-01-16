package com.codedecode.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codedecode.demo.custom.exception.BusinessException;
import com.codedecode.demo.custom.exception.DAOLayerException;
import com.codedecode.demo.entity.Department;
import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repos.DepartmentCrudRepo;
import com.codedecode.demo.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeCrudRepo crudRepo;
	
	@Autowired
	private DepartmentCrudRepo departmentCrudRepo;

	@Override
	public Employee getEmpById(Long empidL) {
		try {
			Employee e = crudRepo.findById(empidL).get();
			if (e.getName().equalsIgnoreCase("code")) {
				BusinessException be = new BusinessException("403", "Not allowed to access this employee");
				be.initCause(new PermissionDeniedDataAccessException("dont access employee with this name", null));
				throw be;
			}
			return e;
		}
		catch (NoSuchElementException e) {
			e.initCause(new DAOLayerException());
			throw e;
		}
	}

	@Override
	public List<Department> getAllDepartmets() {
		List<Department>  departments =	departmentCrudRepo.findAll();
		//List<Department>  departments =	departmentCrudRepo.findWithoutNPlusOne();
		
		return departments;
	}


}
