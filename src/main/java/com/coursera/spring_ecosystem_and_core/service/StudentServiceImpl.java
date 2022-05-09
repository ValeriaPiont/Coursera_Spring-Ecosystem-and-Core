package com.coursera.spring_ecosystem_and_core.service;

import com.coursera.spring_ecosystem_and_core.core.Student;
import com.coursera.spring_ecosystem_and_core.dao.StudentDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Setter
@Getter
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    private int numberOfStudents;

    // will return list of English Literature department students
    @Value("#{dao.getAll().?[dept.equals('${department}')]}")
    private Collection<Student>  departments = new ArrayList<>();

    @Override
    public Student get(long id) {
        return studentDao.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentDao.getAll().stream().limit(numberOfStudents).collect(Collectors.toList());
    }

}
