package com.neosofttech.SpringBootRestPOC.Service.ServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosofttech.SpringBootRestPOC.Commons.CommonConstants;
import com.neosofttech.SpringBootRestPOC.Commons.DashboardResponse;
import com.neosofttech.SpringBootRestPOC.Model.UserDetails;
import com.neosofttech.SpringBootRestPOC.Repository.UserDetailsRepository;
import com.neosofttech.SpringBootRestPOC.Repository.UserMasterRepository;
import com.neosofttech.SpringBootRestPOC.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
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
                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, userDetails);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
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
                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, userDetailsList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
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
                dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);
                dashboardResponse.setResponseData(USER_DETAILS, activeUserDetailsList);
            } else
                errorMsg = "No Records found for requested input.";

        } catch (Exception e) {
            errorMsg = "Following exception occur while fetching User Details.";
            LOGGER.error(errorMsg + "\n\r : "+e.getStackTrace());
        }
        if(errorMsg != null){
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setErrorMsg(errorMsg);
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        LOGGER.trace("Exiting getAllActiveUsers() from UserServiceImpl with return:: returnValue: "+returnValue);
        return returnValue;
    }
}
