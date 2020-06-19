package com.neosofttech.SpringBootRestPOC.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_employment_details")
@Setter
@Getter
public class UserEmployment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userEmploymentId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
