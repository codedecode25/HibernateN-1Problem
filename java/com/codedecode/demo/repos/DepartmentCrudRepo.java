package com.codedecode.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codedecode.demo.entity.Department;

public interface DepartmentCrudRepo extends JpaRepository<Department, Long> {
	
	 @Query("SELECT p FROM Department p LEFT JOIN FETCH p.listOfEmployees")  
	    List<Department> findWithoutNPlusOne();
	 
//	 @EntityGraph(attributePaths = {"listOfEmployees"}) 
//	 List<Department> findAll();
	 

}
