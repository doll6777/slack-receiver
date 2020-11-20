package com.webhook.receiver.slack.vo;


public abstract class AlarmChecker<T> extends Checker {
    protected T detectedValue;
    
    public AlarmChecker(T detectedValue) {
        this.detectedValue = detectedValue;
    }
    
    public T getDetectedValue() {
        return detectedValue;
    }
    
    @Override
    public String getDetectedValueString() {
        return detectedValue.toString();
    }
}
