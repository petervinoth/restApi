package com.rest.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.Entity.Employee;

import com.rest.Repository.restrepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	restrepository employeeRepository;
	
	/*to save an employee*/
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Optional<Employee> findById(Long empid) {
		return employeeRepository.findById(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	

}