package com.webhook.receiver.slack.webhook.dto;

public class PinpointWebhookPayload {
    private String pinpointUrl;
    private String batchEnv;
    private Integer sequenceCount;
    private String applicationId;
    private String checkerName;
    private Integer threshold;
    private String notes;
    private String checkerType;
    private CheckerValue checkerValue;
    private UserGroupMemberPayload userGroupMemberPayload;
    
    public UserGroupMemberPayload getUserGroupMemberPayload() {
        return userGroupMemberPayload;
    }
    
    public String getPinpointUrl() {
        return pinpointUrl;
    }
    
    public String getCheckerType() {
        return checkerType;
    }
    
    public String getBatchEnv() {
        return batchEnv;
    }
    
    public Integer getSequenceCount() {
        return sequenceCount;
    }
    
    public String getApplicationId() {
        return applicationId;
    }
    
    public String getCheckerName() {
        return checkerName;
    }
    
    public Integer getThreshold() {
        return threshold;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public CheckerValue getCheckerValue() {
        return checkerValue;
    }
    
    public void setPinpointUrl(String pinpointUrl) {
        this.pinpointUrl = pinpointUrl;
    }
    
    public void setBatchEnv(String batchEnv) {
        this.batchEnv = batchEnv;
    }
    
    public void setSequenceCount(Integer sequenceCount) {
        this.sequenceCount = sequenceCount;
    }
    
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    
    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }
    
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public void setCheckerType(String checkerType) {
        this.checkerType = checkerType;
    }
    
    public void setCheckerValue(CheckerValue checkerValue) {
        this.checkerValue = checkerValue;
    }
    
    public void setUserGroupMemberPayload(UserGroupMemberPayload userGroupMemberPayload) {
        this.userGroupMemberPayload = userGroupMemberPayload;
    }
}
