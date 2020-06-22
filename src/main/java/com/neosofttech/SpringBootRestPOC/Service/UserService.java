package com.neosofttech.SpringBootRestPOC.Service;

public interface UserService {

    public String getUserByFirstNameAndLastName(String dashboardRequest) throws Exception;

    public String getAllUsers() throws Exception;

    public String getAllActiveUsers() throws Exception;
}
