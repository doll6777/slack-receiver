package com.webhook.receiver.slack.vo;

public class UserMember {
    
    private String id;
    private String name;
    private String email;
    private String department;
    private String phoneNumber;
    private int phoneCountryCode;
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public int getPhoneCountryCode() {
        return phoneCountryCode;
    }
}
