package com.neosofttech.SpringBootRestPOC.Bootstrap;

import com.neosofttech.SpringBootRestPOC.Model.*;
import com.neosofttech.SpringBootRestPOC.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserEducationRepository userEducationRepository;

    @Autowired
    private UserEmploymentRepository userEmploymentRepository;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.trace("Starting run() from DataLoader");

        LOGGER.trace("Creating UserMaster...");
        UserMaster userMaster1 = new UserMaster();
        //userMaster1.setUserId(1L);
        userMaster1.setUserName("domnicarman00");
        userMaster1.setPassword("0domnicA@0");
        userMaster1.setIsActive(Boolean.FALSE);
        userMaster1.setCreatedDate(LocalDate.of(2020,6,22));
        userMasterRepository.save(userMaster1);
        LOGGER.trace("UserMaster Created.");

        LOGGER.trace("Creating UserAddress...");
        UserAddress userAddress1 = new UserAddress();
        //userAddress1.setAddressId(1L);
        userAddress1.setAddressLine1("455, Sector 3, HighNashvilla cottage");
        userAddress1.setAddressLine2("Harrington road, torvalds center town");
        userAddress1.setCity("torvalds");
        userAddress1.setState("hausan");
        userAddress1.setCountry("USA");
        userAddress1.setPincode(900233L);
        userAddress1.setCreatedDate(LocalDate.of(2020,6,22));
        userAddressRepository.save(userAddress1);
        LOGGER.trace("UserAddress Created.");

        LOGGER.trace("Creating UserEducation1...");
        UserEducation userEducation1 = new UserEducation();
        //userEducation1.setUserEducationId(1L);
        userEducation1.setCourseName("SSC");
        userEducation1.setInstituteName("Problex Education Center");
        userEducation1.setPerformance("78%");
        userEducation1.setYearOfPassing("2007");
        userEducation1.setCreatedDate(LocalDate.of(2020,6,22));
        userEducationRepository.save(userEducation1);
        LOGGER.trace("UserEducation1 Created.");

        LOGGER.trace("Creating UserEducation2...");
        UserEducation userEducation2 = new UserEducation();
        //userEducation2.setUserEducationId(2L);
        userEducation2.setCourseName("HSC");
        userEducation2.setInstituteName("Van John Junior college");
        userEducation2.setPerformance("89%");
        userEducation2.setYearOfPassing("2009");
        userEducation2.setCreatedDate(LocalDate.of(2020,6,22));
        userEducationRepository.save(userEducation2);
        LOGGER.trace("UserEducation2 Created.");

        List<UserEducation> userEducationList = new ArrayList<>();
        userEducationList.add(userEducation1);
        userEducationList.add(userEducation2);

        LOGGER.trace("Creating UserEmployment...");
        UserEmployment userEmployment1 = new UserEmployment();
        //userEmployment1.setUserEmploymentId(1L);
        userEmployment1.setCompanyName("Zinx Solutions pvt ltd");
        userEmployment1.setLocation("North Carolina, USA");
        userEmployment1.setDesignation("Data Analyst");
        userEmployment1.setStartDate(LocalDate.of(2010, 8, 2));
        userEmployment1.setCreatedDate(LocalDate.of(2020,6,22));
        userEmploymentRepository.save(userEmployment1);
        LOGGER.trace("UserEmployment Created.");

        LOGGER.trace("Creating UserDetails...");
        UserDetails userDetails1 = new UserDetails();
        //userDetails1.setUserDetailsId(1L);
        userDetails1.setUserMaster(userMaster1);
        userDetails1.setFirstName("Alex");
        userDetails1.setLastName("Roman");
        userDetails1.setDateOfBirth(LocalDate.of(1991, 9, 15));
        userDetails1.setEmailId("domnicarman@gmail.com");
        userDetails1.setGender(Gender.MALE);
        userDetails1.setUserAddresses(Collections.singletonList(userAddress1));
        userDetails1.setUserEducations((userEducationList));
        userDetails1.setUserEmploymentDetails(Collections.singletonList(userEmployment1));
        userDetails1.setCreatedDate(LocalDate.of(2020,6,22));
        userDetailsRepository.save(userDetails1);
        LOGGER.trace("UserDetails Created.");

    }
}
