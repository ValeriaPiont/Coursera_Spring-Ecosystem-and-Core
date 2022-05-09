package com.coursera.spring_ecosystem_and_core.dao;

import com.coursera.spring_ecosystem_and_core.core.Student;
import java.util.Collection;

public interface StudentDao {
	
	Student getOne(long id);

	Collection<Student> getAll();
}
