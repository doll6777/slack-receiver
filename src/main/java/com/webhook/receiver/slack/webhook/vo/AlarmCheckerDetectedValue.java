package com.webhook.receiver.slack.webhook.vo;

public abstract class AlarmCheckerDetectedValue<T> implements CheckerDetectedValue {
    
    protected T detectedValue;
    
    protected AlarmCheckerDetectedValue(T detectedValue) {
        this.detectedValue = detectedValue;
    }
    
    public T getDetectedValue() {
        return detectedValue;
    }
    
}
