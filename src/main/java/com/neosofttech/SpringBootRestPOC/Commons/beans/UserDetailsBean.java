package com.neosofttech.SpringBootRestPOC.Commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonPropertyDescription("User's First Name")
    @JsonProperty("first_name")
    private String firstName;

    @JsonPropertyDescription("User's Last Name")
    @JsonProperty("last_name")
    private String lastName;

    @JsonPropertyDescription("User's Date of Birth.")
    @JsonProperty("dob")
    private String dob;

    @JsonPropertyDescription("User's Email Id")
    @JsonProperty("email_id")
    private String emailId;

    @JsonPropertyDescription("User's Gender")
    @JsonProperty("gender")
    private String gender;

}
