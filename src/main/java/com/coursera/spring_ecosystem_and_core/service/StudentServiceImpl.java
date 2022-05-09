package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import lombok.Setter;

import java.util.Collection;
import java.util.stream.Collectors;

@Setter
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    private int numberOfStudents;

    @Override
    public Student get(long id) {
        return studentDao.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentDao.getAll().stream().limit(numberOfStudents).collect(Collectors.toList());
    }

}
