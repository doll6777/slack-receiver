package com.webhook.receiver.slack.webhook.dto;

public class LongValueAlarmCheckerDetectedValue extends AlarmCheckerDetectedValue<Long> {
    
    public LongValueAlarmCheckerDetectedValue(String unit, Long detectedValue) {
        super(unit, detectedValue);
    }
    
    @Override
    public Long getDetectedValue() {
        return detectedValue;
    }
    
    @Override
    public String getUnit() {
        return unit;
    }
    
    @Override
    public String getMessage() {
        return String.format("value is %s%s during the past 5 mins.", detectedValue, unit);
    }
    
}
