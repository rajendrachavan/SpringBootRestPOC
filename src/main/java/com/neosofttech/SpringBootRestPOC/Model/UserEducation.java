package com.neosofttech.SpringBootRestPOC.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_education_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
}
