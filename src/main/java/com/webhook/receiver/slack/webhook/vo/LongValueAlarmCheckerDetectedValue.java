package com.webhook.receiver.slack.webhook.vo;


public class LongValueAlarmCheckerDetectedValue extends AlarmCheckerDetectedValue<Long> {
    
    public LongValueAlarmCheckerDetectedValue(Long detectedValue) {
        super(detectedValue);
    }
    
    @Override
    public String getMessage() {
        return "LongValueAlarmChecker Message";
    }
    
}
