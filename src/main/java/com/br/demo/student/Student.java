package com.br.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateOfBirthday;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String email, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Student(String name, String email, LocalDate dateOfBirthday) {
        this.name = name;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirthday, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) { this.age = age; }
}
