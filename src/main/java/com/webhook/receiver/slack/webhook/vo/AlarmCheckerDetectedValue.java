package com.webhook.receiver.slack.webhook.vo;


public abstract class AlarmCheckerDetectedValue<T> implements CheckerDetectedValue {
    
    protected T value;
    
    public AlarmCheckerDetectedValue(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "AlarmCheckerDetectedValue{" +
                "value=" + value +
                '}';
    }
}
