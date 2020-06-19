package com.neosofttech.SpringBootRestPOC.repository;

import com.neosofttech.SpringBootRestPOC.model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
}
