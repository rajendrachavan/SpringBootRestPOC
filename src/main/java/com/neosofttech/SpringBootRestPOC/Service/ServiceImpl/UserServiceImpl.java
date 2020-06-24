package com.neosofttech.SpringBootRestPOC.Service.ServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosofttech.SpringBootRestPOC.Commons.CommonConstants;
import com.neosofttech.SpringBootRestPOC.Commons.DashboardResponse;
import com.neosofttech.SpringBootRestPOC.Commons.beans.UserDetailsBean;
import com.neosofttech.SpringBootRestPOC.Model.UserDetails;
import com.neosofttech.SpringBootRestPOC.Repository.UserDetailsRepository;
import com.neosofttech.SpringBootRestPOC.Repository.UserMasterRepository;
import com.neosofttech.SpringBootRestPOC.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USER_ID = "user_id";
    private static final String USER_DETAILS = "user_details";

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Override
    public String getUserByFirstNameAndLastName(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting getUserByFirstNameAndLastName() from UserServiceImpl with arguments:: dashboardRequest: "+dashboardRequest);
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
            String firstName = requestJsonNode.get(FIRST_NAME).asText();
            String lastName = requestJsonNode.get(LAST_NAME).asText();

            UserDetails userDetails = this.userDetailsRepository.findUserByFirstNameAndLastName(firstName, lastName);
            if(userDetails != null) {
                UserDetailsBean uDetailsBean = new UserDetailsBean();
                uDetailsBean.setFirstName(userDetails.getFirstName());
                uDetailsBean.setLastName(userDetails.getLastName());
                uDetailsBean.setDob(userDetails.getDateOfBirth().format(CommonConstants.DTF_dd_MM_yyyy));
                uDetailsBean.setGender(userDetails.getGender().name());
                uDetailsBean.setEmailId(userDetails.getEmailId());
                uDetailsBean.setUserAddress(userDetails.getUserAddresses().stream().filter(x -> x.getAddressStatus().equals("permanent")).findFirst().toString());

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, uDetailsBean);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getUserByFirstNameAndLastName() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String getAllUsers() throws Exception {
        LOGGER.trace("Starting getAllUsers() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            List<UserDetails> userDetailsList = this.userDetailsRepository.findAll();
            LOGGER.trace("USER_DETAILS_LIST:: "+userDetailsList);
            if(!userDetailsList.isEmpty()) {
                List<UserDetailsBean> userDetailsBeanList = userDetailsList.stream().map(userDetails -> {
                    UserDetailsBean uDetailsBean = new UserDetailsBean();
                    uDetailsBean.setFirstName(userDetails.getFirstName());
                    uDetailsBean.setLastName(userDetails.getLastName());
                    uDetailsBean.setDob(userDetails.getDateOfBirth().format(CommonConstants.DTF_dd_MM_yyyy));
                    uDetailsBean.setGender(userDetails.getGender().name());
                    uDetailsBean.setEmailId(userDetails.getEmailId());
                    uDetailsBean.setUserAddress(userDetails.getUserAddresses().stream().filter(x -> x.getAddressStatus().equals("permanent")).findFirst().toString());
                    return uDetailsBean;
                }).collect(Collectors.toList());

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, userDetailsBeanList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getAllUsers() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String getAllActiveUsers() throws Exception {
        LOGGER.trace("Starting getAllActiveUsers() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            List<UserDetails> activeUserDetailsList = this.userDetailsRepository.findAllActiveUsers();
            LOGGER.trace("ACTIVE_USER_DETAILS_LIST:: "+activeUserDetailsList);
            if(!activeUserDetailsList.isEmpty()) {
                List<UserDetailsBean> userDetailsBeanList = activeUserDetailsList.stream().map(userDetails -> {
                    UserDetailsBean uDetailsBean = new UserDetailsBean();
                    uDetailsBean.setFirstName(userDetails.getFirstName());
                    uDetailsBean.setLastName(userDetails.getLastName());
                    uDetailsBean.setDob(userDetails.getDateOfBirth().format(CommonConstants.DTF_dd_MM_yyyy));
                    uDetailsBean.setGender(userDetails.getGender().name());
                    uDetailsBean.setEmailId(userDetails.getEmailId());
                    uDetailsBean.setUserAddress(userDetails.getUserAddresses().stream().filter(x -> x.getAddressStatus().equals("permanent")).findFirst().get().toString());
                    return uDetailsBean;
                }).collect(Collectors.toList());

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, userDetailsBeanList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getAllActiveUsers() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String sortUsersByDob() throws Exception {
        LOGGER.trace("Starting sortUsersByDob() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            List<UserDetails> sortedUsers = this.userDetailsRepository.sortActiveUsersByDob();
            if(!sortedUsers.isEmpty()) {
                List<UserDetailsBean> udBeanSortedList = sortedUsers.stream().map(userDetails -> {
                    UserDetailsBean uDetailsBean = new UserDetailsBean();
                    uDetailsBean.setFirstName(userDetails.getFirstName());
                    uDetailsBean.setLastName(userDetails.getLastName());
                    uDetailsBean.setDob(userDetails.getDateOfBirth().format(CommonConstants.DTF_dd_MM_yyyy));
                    uDetailsBean.setGender(userDetails.getGender().name());
                    uDetailsBean.setEmailId(userDetails.getEmailId());
                    uDetailsBean.setUserAddress(userDetails.getUserAddresses().stream().filter(x -> x.getAddressStatus().equals("permanent")).findFirst().get().toString());
                    return uDetailsBean;
                }).collect(Collectors.toList());

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, udBeanSortedList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting sortUsersByDob() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String sortUsersByDoj() throws Exception {
        LOGGER.trace("Starting sortUsersByDoj() from UserServiceImpl");
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            List<UserDetails> sortedUsers = this.userDetailsRepository.sortUsersByDoj();
            if(!sortedUsers.isEmpty()) {
                List<UserDetailsBean> udBeanSortedList = sortedUsers.stream().map(userDetails -> {
                    UserDetailsBean uDetailsBean = new UserDetailsBean();
                    uDetailsBean.setFirstName(userDetails.getFirstName());
                    uDetailsBean.setLastName(userDetails.getLastName());
                    uDetailsBean.setDob(userDetails.getDateOfBirth().format(CommonConstants.DTF_dd_MM_yyyy));
                    uDetailsBean.setGender(userDetails.getGender().name());
                    uDetailsBean.setEmailId(userDetails.getEmailId());
                    uDetailsBean.setUserAddress(userDetails.getUserAddresses().stream().filter(x -> x.getAddressStatus().equals("permanent")).findFirst().get().toString());
                    return uDetailsBean;
                }).collect(Collectors.toList());

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, udBeanSortedList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting sortUsersByDoj() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String deleteUserById(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting deleteUserById() from UserServiceImpl with arguments:: dashboardRequest: "+dashboardRequest);
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
            Long userId = requestJsonNode.get(USER_ID).asLong();

            UserDetails userDetails = this.userDetailsRepository.findById(userId).orElse(null);
            if(userDetails != null) {
                this.userDetailsRepository.deleteById(userId);

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, "User deleted successfully from database.");
            } else
                errorMsg = "No Records found for requested user";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting deleteUserById() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }

    @Override
    public String deactivateUserById(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting deactivateUserById() from UserServiceImpl with arguments:: dashboardRequest: "+dashboardRequest);
        String returnValue = null;
        String errorMsg = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        try {
            JsonNode requestJsonNode = MAPPER.readTree(dashboardRequest);
            Long userId = requestJsonNode.get(USER_ID).asLong();

            UserDetails userDetails = this.userDetailsRepository.findById(userId).orElse(null);
            if(userDetails != null) {
                userDetails.getUserMaster().setIsActive(Boolean.FALSE);
                this.userDetailsRepository.save(userDetails);

                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, "User deactivated successfully.");
            } else
                errorMsg = "No Records found for requested user.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+ Arrays.toString(e.getStackTrace()));
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting deactivateUserById() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }
}
