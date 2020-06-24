package com.neosofttech.SpringBootRestPOC.Service;

public interface UserService {

    public String getUserByFirstNameAndLastName(String dashboardRequest) throws Exception;

    public String getAllUsers() throws Exception;

    public String getAllActiveUsers() throws Exception;

    public String sortUsersByDob() throws Exception;

    public String sortUsersByDoj() throws Exception;

    public String deleteUserById(String dashboardRequest) throws Exception;

    public String deactivateUserById(String dashboardRequest) throws Exception;
}
