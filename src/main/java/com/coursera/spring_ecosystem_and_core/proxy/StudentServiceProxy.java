package com.coursera.spring_ecosystem_and_core.proxy;

import java.util.Collection;
import java.util.stream.Collectors;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDaoImpl;
import com.coursera.spring_ecosystem_and_core.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class StudentServiceProxy implements StudentService {

	private final StudentService service;

	@Value("${department}")
	private String department;

	public StudentServiceProxy(StudentService service) {
		super();
		this.service = service;
	}

	@Override
	public Student get(long id) {
		log.info("Calling Service get(id)");
		return service.get(id);
	}

	@Override
	public Collection<Student> getAllStudents() {
		log.info("Calling Service getAllStudents()");
		return service.getAllStudents();
	}

	public Collection<Student> getStudentsInDepartment() {
		log.info("Calling Service getStudentsInDepartment()");
		return new StudentDaoImpl().getAll().stream()
				.filter(p-> p.getDept().equals(department))
				.collect(Collectors.toList());
	}

}
