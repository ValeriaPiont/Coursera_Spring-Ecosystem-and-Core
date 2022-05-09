package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;

import java.util.Collection;

public interface StudentService {
	
	Student get(long id);

	Collection<Student> getAllStudents();

}
