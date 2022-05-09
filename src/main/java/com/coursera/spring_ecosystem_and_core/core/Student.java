package com.coursera.spring_ecosystem_and_core.core;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue()
    private long id;

    private String firstName;

    private String surname;

    private String dept;

    private Double fees;

    public Student(String firstName, String surname, String dept, Double fees) {
        this.firstName = firstName;
        this.surname = surname;
        this.dept = dept;
        this.fees = fees;
    }
}
