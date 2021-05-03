package com.students.test_students.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;


@Entity

@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "FirstName is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "LastName is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "MiddleName is mandatory")
    @Column(name = "middle_name")
    private String middleName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotBlank(message = "Group is mandatory")
    @Column(name = "group_number")
    private String groupNumber;


    public Student() {
    }

    public Student(String firstName, String lastName, String middleName, Date dateOfBirth, String groupNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.groupNumber = groupNumber;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
