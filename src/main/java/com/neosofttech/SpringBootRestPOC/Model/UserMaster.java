package com.neosofttech.SpringBootRestPOC.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user_master")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;
}
