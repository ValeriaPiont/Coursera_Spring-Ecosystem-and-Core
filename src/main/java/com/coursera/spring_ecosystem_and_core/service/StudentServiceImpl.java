package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDao;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Override
    public Student get(long id) {
        return studentDao.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentDao.getAll();
    }

}
