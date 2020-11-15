package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("LongValueAlarmChecker")
public class LongValueAlarmChecker extends Checker {
    // TODO : LongValueAlarmCheckerDetectedValue 로 바꿔야 하고, CheckerDetectedValue 타입의 Long Value 를 어떻게 넣을수 있는가?
    private LongValueAgentCheckerDetectedValue detectedValue;
    
    @Override
    public CheckerDetectedValue getDetectedValue() {
        return detectedValue;
    }
}