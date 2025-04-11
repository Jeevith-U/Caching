package com.jeevith.caching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jeevith.caching.entity.Student;
import com.jeevith.caching.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo ;
	
	public Student saveStudent(Student student) {
		
			return studentRepo.save(student) ;
	}
	
	@Cacheable(value = "student", key = "#root.args[0]")
	public Student findStudentById(int id) {
	    return studentRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Unable to find the student with specified id"));
	}

	
	@CachePut(value = "student", key = "#root.args[0]")
	public Student updateStudentDetails(Student student) {
		
		if(findStudentById(student.getStudentId()) != null) {
			return studentRepo.saveAndFlush(student) ;
		}
		else return null ;
	}
	
	@CacheEvict(value = "student", key = "#root.args[0]")
	public boolean deleteStudent(int id) {
		
		Student student = findStudentById(id) ;
		
		if(student != null){
			studentRepo.delete(student);
			return true ;
		}
		else {
			return false   ;
		}
	}
	
	@CacheEvict(value = "studentCache", allEntries = true)
	public void evictAllCacheValues() {
	    System.out.println("Clearing entire students cache");
	}

}
