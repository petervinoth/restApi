package com.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Entity.Employee;


@Repository
public interface restrepository extends JpaRepository<Employee , Long > {
	
      // Employee findById(long id);
}
