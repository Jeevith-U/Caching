package com.jeevith.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeevith.caching.entity.Student;
import com.jeevith.caching.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service ;
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		System.out.println(student);
		return service.saveStudent(student) ;
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@RequestParam int id) {
		return service.findStudentById(id) ;
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestAttribute Student student) {
		return service.updateStudentDetails(student) ;
	}
	
	@DeleteMapping("/student/{id}")
	public boolean deleteStudent(@RequestParam int id) {
		return service.deleteStudentDetails(id) ;
	}
}
