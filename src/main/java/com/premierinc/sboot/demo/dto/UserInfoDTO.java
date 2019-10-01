package com.premierinc.sboot.demo.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Component
public class UserInfoDTO {

    private Integer id;

    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;
    
    @NotNull
    @Size(min=1)
    private String address;

    @NotNull
    @Size(min=1)
    private String mobile;

    private String userName;

    @NotNull
    @Size(min=1)
    private List<String> emailAddresses;

/*    @NotNull
    @Size(min=1)
    @Pattern(regexp = ".+@.+\\..+")
    private String emailAddress;*/

    public UserInfoDTO() {
    }

    public UserInfoDTO(Integer id, String firstName, String lastName, String address, String mobile, List<String> emailAddresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        if (mobile != "") {
            this.mobile = mobile;
        } else {
            this.mobile = "0000000000"
        }
        
        this.userName = this.firstName + " " + this.lastName;
        this.emailAddresses = emailAddresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userName='" + userName + '\'' +
                ", emailAddresses=" + emailAddresses +
                '}';
    }
}
