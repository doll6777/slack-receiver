package com.webhook.receiver.slack.webhook.dto;

public abstract class CheckerValue {
    
    private final String unit;
    
    public CheckerValue(String unit) {
        this.unit = unit;
    }
    
    public String getUnit() {
        return unit;
    }
}
