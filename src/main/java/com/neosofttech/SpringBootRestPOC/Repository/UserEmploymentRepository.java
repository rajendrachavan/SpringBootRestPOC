package com.neosofttech.SpringBootRestPOC.Repository;

import com.neosofttech.SpringBootRestPOC.Model.UserEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmploymentRepository extends JpaRepository<UserEmployment, Long> {
}
