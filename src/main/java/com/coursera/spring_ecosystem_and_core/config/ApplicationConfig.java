package com.coursera.spring_ecosystem_and_core.config;

import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import com.coursera.spring_ecosystem_and_core.dao.StudentDaoImpl;
import com.coursera.spring_ecosystem_and_core.proxy.StudentServiceProxy;
import com.coursera.spring_ecosystem_and_core.service.StudentService;
import com.coursera.spring_ecosystem_and_core.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("{$max}")
    private int numberOfStudents;

    @Conditional(StudentConditional_Prod.class)
    @Bean(name = "service")
    public StudentService studentService() {
        StudentServiceImpl service = new StudentServiceImpl();
        service.setStudentDao(studentDao());
        service.setNumberOfStudents(numberOfStudents);
        return service;
    }

    @Conditional(StudentConditional_Test.class)
    @Bean(name = "service")
    public StudentService studentServiceTest() {
        StudentServiceImpl service = new StudentServiceImpl();
        service.setStudentDao(studentDao());
        service.setNumberOfStudents(numberOfStudents);
        return new StudentServiceProxy(service);
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDaoImpl();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
