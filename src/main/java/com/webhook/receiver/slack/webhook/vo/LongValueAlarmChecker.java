package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("LongValueAlarmChecker")
public class LongValueAlarmChecker extends Checker {
    private LongValueAgentCheckerDetectedValue detectedValue;
    
    @Override
    public CheckerDetectedValue getDetectedValue() {
        return detectedValue;
    }
}