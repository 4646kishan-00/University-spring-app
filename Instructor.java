package com.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "advisor")
    private List<Student> advisedStudents;

    // Constructor
    public Instructor(String name, String email, String phone, Department department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    // Default constructor (required by JPA)
    public Instructor() {}

    // Getters and Setters
    public Long getInstructorId() {
        return instructorId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getAdvisedStudents() {
        return advisedStudents;
    }

    public void setAdvisedStudents(List<Student> advisedStudents) {
        this.advisedStudents = advisedStudents;
    }
}
