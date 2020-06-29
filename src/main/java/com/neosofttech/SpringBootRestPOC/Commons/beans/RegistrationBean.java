package com.neosofttech.SpringBootRestPOC.Commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonPropertyDescription("Username")
    @JsonProperty("username")
    @NonNull
    private String username;

    @JsonPropertyDescription("User's password")
    @JsonProperty("last_name")
    @NonNull
    @Size(min = 8, message = "password is less than 8 characters")
    private String password;

    @JsonPropertyDescription("User's First Name")
    @JsonProperty("first_name")
    @NonNull
    @Pattern(regexp ="([a-zA-Z]){2,16}", message = "invalid firstName")
    private String firstName;

    @JsonPropertyDescription("User's Last Name")
    @JsonProperty("last_name")
    @NonNull
    @Pattern(regexp ="([a-zA-Z]){2,16}", message = "invalid lastName")
    private String lastName;

    @JsonPropertyDescription("User's Date of Birth.")
    @JsonProperty("dob")
    @NonNull
    private String dob;

    @JsonPropertyDescription("User's Email Id")
    @JsonProperty("email_id")
    @NonNull
    @Pattern(regexp ="^([A-Za-z0-9])(([.])?[0-9a-z])*[@]([a-z])+([.]([a-z])+){1,3}", message = "invalid email")
    private String emailId;

    @JsonPropertyDescription("User's Gender")
    @JsonProperty("gender")
    @NonNull
    private String gender;

    @JsonPropertyDescription("User's address type")
    @JsonProperty("address_type")
    @NonNull
    private String addressType;

    @JsonPropertyDescription("User's address line 1")
    @JsonProperty("address_line_1")
    @NonNull
    private String addressLine1;

    @JsonPropertyDescription("User's address line 2")
    @JsonProperty("address_line_2")
    private String addressLine2;

    @JsonPropertyDescription("User's country")
    @JsonProperty("country")
    @NonNull
    private String country;

    @JsonPropertyDescription("User's address pincode")
    @JsonProperty("pincode")
    @NonNull
    @Size(min = 6, max = 6, message = "Invalid Pincode")
    private String pincode;

    @JsonPropertyDescription("user's company name")
    @JsonProperty("company_name")
    @NonNull
    private String companyName;

    @JsonPropertyDescription("User-company's location")
    @JsonProperty("location")
    @NonNull
    private String location;

    @JsonPropertyDescription("User's date of joining")
    @JsonProperty("date_of_joining")
    @NonNull
    private String dateOfJoining;

    @JsonPropertyDescription("designation")
    @JsonProperty("designation")
    @NonNull
    private String designation;
}
