package com.jeevith.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeevith.caching.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
