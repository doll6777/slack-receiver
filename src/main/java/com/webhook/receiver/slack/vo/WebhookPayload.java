package com.webhook.receiver.slack.vo;

public class WebhookPayload {
    private final String pinpointUrl;
    private final String batchEnv;
    private final String applicationId;
    private final String serviceType;
    private final UserGroup userGroup;
    private final Checker checker;
    private final String unit;
    private final Integer threshold;
    private final String notes;
    private final Integer sequenceCount;
    
    public WebhookPayload(String pinpointUrl, String batchEnv, String applicationId, String serviceType, UserGroup userGroup, Checker checker, String unit, Integer threshold, String notes, Integer sequenceCount) {
        this.pinpointUrl = pinpointUrl;
        this.batchEnv = batchEnv;
        this.applicationId = applicationId;
        this.serviceType = serviceType;
        this.userGroup = userGroup;
        this.checker = checker;
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
    
    public UserGroup getUserGroup() {
        return userGroup;
    }
    
    public Checker getChecker() {
        return checker;
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
                ", userGroup=" + userGroup +
                ", checkerDetectedValue=" + checker +
                ", unit='" + unit + '\'' +
                ", threshold=" + threshold +
                ", notes='" + notes + '\'' +
                ", sequenceCount=" + sequenceCount +
                '}';
    }
}
