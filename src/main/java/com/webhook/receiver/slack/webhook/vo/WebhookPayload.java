package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class WebhookPayload {
    private final String pinpointUrl;
    private final String batchEnv;
    private final String applicationId;
    private final String serviceType;
    private final String checkerName;
    private final String checkerType;
    private final UserGroup userGroup;
    private final CheckerDetectedValue checkerDetectedValue;
    private final String unit;
    private final Integer threshold;
    private final String notes;
    private final Integer sequenceCount;
    
    public WebhookPayload(String pinpointUrl, String batchEnv, String applicationId, String serviceType, String checkerName, String checkerType, UserGroup userGroup, CheckerDetectedValue checkerDetectedValue, String unit, Integer threshold, String notes, Integer sequenceCount) {
        this.pinpointUrl = pinpointUrl;
        this.batchEnv = batchEnv;
        this.applicationId = applicationId;
        this.serviceType = serviceType;
        this.checkerName = checkerName;
        this.checkerType = checkerType;
        this.userGroup = userGroup;
        this.checkerDetectedValue = checkerDetectedValue;
        this.unit = unit;
        this.threshold = threshold;
        this.notes = notes;
        this.sequenceCount = sequenceCount;
    }
    
    public String getPinpointUrl() {
        return pinpointUrl;
    }
    
    public String getBatchEnv() {
        return batchEnv;
    }
    
    public String getApplicationId() {
        return applicationId;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public String getCheckerName() {
        return checkerName;
    }
    
    public String getCheckerType() {
        return checkerType;
    }
    
    public UserGroup getUserGroup() {
        return userGroup;
    }
    
    public CheckerDetectedValue getCheckerDetectedValue() {
        return checkerDetectedValue;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public Integer getThreshold() {
        return threshold;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public Integer getSequenceCount() {
        return sequenceCount;
    }
    
    @Override
    public String toString() {
        return "WebhookPayload{" +
                "pinpointUrl='" + pinpointUrl + '\'' +
                ", batchEnv='" + batchEnv + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", checkerName='" + checkerName + '\'' +
                ", checkerType='" + checkerType + '\'' +
                ", userGroup=" + userGroup +
                ", checkerDetectedValue=" + checkerDetectedValue +
                ", unit='" + unit + '\'' +
                ", threshold=" + threshold +
                ", notes='" + notes + '\'' +
                ", sequenceCount=" + sequenceCount +
                '}';
    }
}
