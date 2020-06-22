package com.neosofttech.SpringBootRestPOC.Repository;

import com.neosofttech.SpringBootRestPOC.Model.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEducationRepository extends JpaRepository<UserEducation, Long> {
}
