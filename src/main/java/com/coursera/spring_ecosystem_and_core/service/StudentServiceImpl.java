package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Setter
@Component(value = "studentService")
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Value("2")
    private int numberOfStudents;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student get(long id) {
        return studentDao.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentDao.getAll().stream().limit(numberOfStudents).collect(Collectors.toList());
    }

}
