package com.neosofttech.SpringBootRestPOC.Repository;

import com.neosofttech.SpringBootRestPOC.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findUserByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT u FROM UserDetails u INNER JOIN u.userMaster um WHERE um.isActive = 1")
    List<UserDetails> findAllActiveUsers();
}
