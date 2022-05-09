package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.config.ApplicationConfig;
import com.coursera.spring_ecosystem_and_core.core.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= ApplicationConfig.class)
class StudentServiceImplTest {

    @Inject
    private StudentService service;

    @Test
    void testContext() {
        assertThat(service, is(notNullValue()));
    }

    @Test
    void testGetOneStudent() {
        Student student =  service.get(1L);
        assertThat(student.getFirstName(), equalTo("Eric"));
        assertThat(student.getSurname(), equalTo("Colbert"));
    }
    @Test
    void tesGetAll() {
        assertThat(service.getAllStudents().size(), equalTo(2));
        service.getAllStudents().forEach(p-> {
            System.out.printf("%-10s %-10s%n",p.getFirstName(), p.getSurname());
        });
    }
}