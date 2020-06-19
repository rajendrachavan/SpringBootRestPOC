package com.neosofttech.SpringBootRestPOC.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_education_details")
@Setter
@Getter
public class UserEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userEducationId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "institute_name", nullable = false)
    private String instituteName;

    @Column(name = "performance", nullable = false)
    private String performance;

    @Column(name = "year_of_passing", nullable = false)
    private String yearOfPassing;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
