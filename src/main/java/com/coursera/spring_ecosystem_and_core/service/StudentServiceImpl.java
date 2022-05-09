package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.inject.Named;
import java.util.Collection;
import java.util.stream.Collectors;

@Setter
@Named(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentDaoImpl")
    private StudentDao studentDao;

    @Value("2")
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
