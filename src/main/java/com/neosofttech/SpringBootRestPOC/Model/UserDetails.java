package com.neosofttech.SpringBootRestPOC.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate dateOfBirth;

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
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
}
