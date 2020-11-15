package com.webhook.receiver.slack.webhook.vo;


public abstract class AlarmChecker<T> extends Checker {
    protected T detectedValue;
    
    public AlarmChecker(T detectedValue) {
        this.detectedValue = detectedValue;
    }
    
    public T getDetectedValue() {
        return detectedValue;
    }
    
    @Override
    public String toString() {
        return detectedValue.toString();
    }
}
