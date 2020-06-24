package com.neosofttech.SpringBootRestPOC.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_employment_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
}
