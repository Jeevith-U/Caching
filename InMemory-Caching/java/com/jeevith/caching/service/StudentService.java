package com.jeevith.caching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jeevith.caching.entity.Student;
import com.jeevith.caching.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@CachePut(value = "students", key = "#student.id")
	public Student saveStudent(Student student) {

		return studentRepo.save(student);
	}

	// 🔹 Fetch student from cache or DB if not found in cache
	@Cacheable(value = "students", key = "#id")
	public Student findStudentById(int id) {

		return studentRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to find the student with specified id"));
	}

	@CachePut(value = "students", key = "#student.id")
	public Student updateStudentDetails(Student student) {

		if (findStudentById(student.getStudentId()) != null) {
			return studentRepo.saveAndFlush(student);
		} else
			return null;
	}

	@CacheEvict(value = "students", key = "#id")
	public boolean deleteStudentDetails(int id) {

		Student foundStudent = findStudentById(id);
		
		if (foundStudent != null) {
			 studentRepo.delete(foundStudent);
			 return true ;
		} else
			return false;
	}

}
