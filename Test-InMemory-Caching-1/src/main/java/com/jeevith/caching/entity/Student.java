package com.jeevith.caching.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	private int studentId ;
	private String studentName ;
	private String studentEmail ;
	private long studentPhno ;
}
