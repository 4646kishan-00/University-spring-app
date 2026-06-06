package com.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Instructor advisor;

    @ManyToMany
    @JoinTable(
        name = "enrollment",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;

    // Constructor
    public Student(String name, String email, String phone, LocalDate dateOfBirth, Instructor advisor) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.advisor = advisor;
    }

    // Default constructor (required by JPA)
    public Student() {}

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Instructor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Instructor advisor) {
        this.advisor = advisor;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
