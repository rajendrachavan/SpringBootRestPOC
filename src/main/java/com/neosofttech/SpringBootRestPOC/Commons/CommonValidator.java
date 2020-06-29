package com.neosofttech.SpringBootRestPOC.Commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosofttech.SpringBootRestPOC.Commons.beans.RegistrationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public abstract class CommonValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonValidator.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public ResponseEntity<Object> responseBuilder(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting responseBuilder() from CommonValidator with arguments:: dashboardRequest: "+dashboardRequest);
        DashboardResponse dashboardResponse = new DashboardResponse();
        dashboardResponse.setStatusCode(CommonConstants.SUCCESS_STATUS);

        LOGGER.trace("Exiting responseBuilder() from CommonValidator with return value:: dashboardResponse: "+dashboardResponse);
        return new ResponseEntity<>(dashboardResponse, HttpStatus.OK);
    }

    public ResponseEntity<Object> responseBuilder(Exception exp) {
        LOGGER.trace("Starting responseBuilder() from CommonValidator with Exception: "+exp);
        DashboardResponse dashboardResponse = new DashboardResponse();
        dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);

        LOGGER.trace("Exiting responseBuilder() from CommonValidator with Exception: "+exp);
        return new ResponseEntity<>(dashboardResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public String validateRegistrationDetails(String dashboardRequest) throws Exception {
        LOGGER.trace("Starting responseBuilder() from CommonValidator with arguments:: dashboardRequest: "+dashboardRequest);
        String returnValue = null;
        DashboardResponse dashboardResponse = new DashboardResponse();
        RegistrationBean registrationBean = MAPPER.readValue(dashboardRequest, RegistrationBean.class);
        Set<ConstraintViolation<RegistrationBean>> violations = validator.validate(registrationBean);
        for (ConstraintViolation<RegistrationBean> violation : violations) {
            dashboardResponse.setStatusCode(CommonConstants.FAIL_STATUS);
            dashboardResponse.setResponseData(violation.getPropertyPath().toString(), violation.getMessage());
        }
        returnValue = MAPPER.writeValueAsString(dashboardResponse);
        return returnValue;
    }

}
