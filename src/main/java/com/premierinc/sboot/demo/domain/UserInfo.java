package com.premierinc.sboot.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 3541377415778960610L;

    @Id
    @SequenceGenerator(name="USER_ID_SEQ", sequenceName="USER_ID_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_ID_SEQ")
    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="ADDRESS")
    private String address;

    @Column(name="MOBILE")
    private String mobile;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CommunicationPref> communicationPrefs;

    public UserInfo() {
    }

    public UserInfo(Integer userId, String lastName, String firstName, String address, String mobile) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.mobile = mobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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


    public List<CommunicationPref> getCommunicationPrefs() {
        return communicationPrefs;
    }

    public void setCommunicationPrefs(List<CommunicationPref> communicationPrefs) {
        this.communicationPrefs = communicationPrefs;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", communicationPrefs=" + communicationPrefs +
                '}';
    }
}
