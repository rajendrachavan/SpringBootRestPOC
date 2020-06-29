package com.neosofttech.SpringBootRestPOC.Repository;

import com.neosofttech.SpringBootRestPOC.Model.UserDetails;
import com.neosofttech.SpringBootRestPOC.Model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findUserByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT ud FROM UserDetails ud INNER JOIN ud.userMasterId um WHERE um.isActive = 1")
    List<UserDetails> findAllActiveUsers();

    @Query("SELECT ud FROM UserDetails ud INNER JOIN ud.userMasterId um WHERE um.isActive = 1 order by ud.dateOfBirth")
    List<UserDetails> sortActiveUsersByDob();

    @Query("SELECT ud FROM UserDetails ud JOIN ud.userMasterId um JOIN ud.userEmploymentDetails uemp WHERE um.isActive = 1 order by uemp.startDate")
    List<UserDetails> sortUsersByDoj();

    UserDetails findByUserMasterId(UserMaster userMaster);
}
