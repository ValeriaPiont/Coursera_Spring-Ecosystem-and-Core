package com.coursera.spring_ecosystem_and_core.config;

import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import com.coursera.spring_ecosystem_and_core.dao.StudentDaoImpl;
import com.coursera.spring_ecosystem_and_core.service.StudentService;
import com.coursera.spring_ecosystem_and_core.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Value("2")
	private int numberOfStudents;

	@Bean(name = "service")
	public StudentService studentService(){
		StudentServiceImpl service =  new StudentServiceImpl();
		service.setStudentDao(studentDao());
		service.setNumberOfStudents(numberOfStudents);
		return service;
	}

	@Bean
	public StudentDao studentDao(){
		return new StudentDaoImpl();
	}

}
