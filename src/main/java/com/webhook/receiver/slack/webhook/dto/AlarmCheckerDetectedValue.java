package com.webhook.receiver.slack.webhook.dto;

public abstract class AlarmCheckerDetectedValue<T> extends CheckerDetectedValue {
    
    protected T detectedValue;
    
    public AlarmCheckerDetectedValue(String unit, T detectedValue) {
        super(unit);
        this.detectedValue = detectedValue;
    }
    
    @Override
    public String getUnit() {
        return unit;
    }
    
    public T getDetectedValue() {
        return detectedValue;
    }
    
    public abstract String getMessage();
}
