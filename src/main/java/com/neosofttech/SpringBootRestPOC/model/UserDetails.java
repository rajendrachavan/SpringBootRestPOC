package com.neosofttech.SpringBootRestPOC.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_details")
@Setter
@Getter
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userDetailsId;

    @OneToOne
    private UserMaster userMaster;

    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "email")
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToMany
    private List<UserAddress> userAddresses;

    @OneToMany
    private List<UserEducation> userEducations;

    @OneToMany
    private List<UserEmployment> userEmploymentDetails;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}
