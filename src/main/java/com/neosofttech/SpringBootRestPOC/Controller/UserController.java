package com.neosofttech.SpringBootRestPOC.Controller;

import com.neosofttech.SpringBootRestPOC.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userManagement/v1/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByFirstNameAndLastName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByFirstNameAndLastName(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting getUserByFirstNameAndLastName() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.getUserByFirstNameAndLastName(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting getUserByFirstNameAndLastName() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers() throws Exception {
        LOGGER.trace("Starting getAllUsers() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.getAllUsers();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting getAllUsers() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/getAllActiveUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActiveUsers() throws Exception {
        LOGGER.trace("Starting getAllActiveUsers() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.getAllActiveUsers();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting getAllActiveUsers() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/sortUsersByDob", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortUsersByDob() throws Exception {
        LOGGER.trace("Starting sortUsersByDob() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.sortUsersByDob();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting sortUsersByDob() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/sortUsersByDoj", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sortUsersByDoj() throws Exception {
        LOGGER.trace("Starting sortUsersByDoj() from UserController");
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.sortUsersByDoj();
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting sortUsersByDoj() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting deleteUser() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.deleteUserById(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting deleteUser() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/deactivateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deactivateUser(@RequestBody String dashboardRequest) throws Exception {
        LOGGER.trace("Starting deactivateUser() from UserController with arguments:: dashboardRequest: "+dashboardRequest);
        ResponseEntity<?> responseEntity = null;
        String jsonString = userService.deactivateUserById(dashboardRequest);
        if(jsonString != null){
            responseEntity = ResponseEntity.ok(jsonString);
        } else
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.trace("Exiting deactivateUser() from UserController with return:: responseEntity: "+responseEntity);
        return responseEntity;
    }

}
