package com.neosofttech.SpringBootRestPOC.Repository;

import com.neosofttech.SpringBootRestPOC.Model.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
}