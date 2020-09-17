package com.webhook.receiver.slack.webhook.dto;

public abstract class CheckerDetectedValue {
    
    protected String unit;
    
    protected CheckerDetectedValue(String unit) {
        this.unit = unit;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public abstract String getMessage();
}