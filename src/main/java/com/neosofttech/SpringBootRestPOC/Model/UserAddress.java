package com.neosofttech.SpringBootRestPOC.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_address")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "address_line_1", length = 100, nullable = false)
    private String addressLine1;

    @Column(name = "address_line_2", length = 100)
    private String addressLine2;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @Column(name = "pincode", length = 6, nullable = false)
    private Long pincode;

    @Column(name = "address_status")
    private String addressStatus;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
}
