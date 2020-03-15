package com.rest.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Entity.Employee;
import com.rest.Repository.restrepository;




@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	restrepository employeeDAO;
	
	/* to save an employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody  Employee emp) {
		return employeeDAO.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Optional<Employee> emp=employeeDAO.findById(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}

	
	
	
	
	
	
	
	//@PutMapping("/employees/{id}")
	//public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long id,@Valid @RequestBody Employee empDetails){
		
		//Optional<Employee> emp=employeeDAO.findById(id);
		//if(!emp.isPresent()) {
			//return ResponseEntity.notFound().build();
		//}
			//empDetails.setId(id);
			//employeeDAO.save(empDetails);
			//return ResponseEntity.noContent().build();
		
		
		
	//}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long id,@Valid @RequestBody Employee emp){
		Employee employee=employeeDAO.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found on :: "+ id));
		employee.setName(emp.getName());
		employee.setDesignation(emp.getDesignation());
		employee.setExpertise(emp.getExperience());
		employee.setCreatedAt(new Date());
		final Employee updateEmployee=employeeDAO.save(employee);
		return ResponseEntity.ok(employee);
		
		
	}
@DeleteMapping("/employees/{id}")
public void delete(@PathVariable Long id) {
	 employeeDAO.deleteById(id);
	
}
}

	
	
	