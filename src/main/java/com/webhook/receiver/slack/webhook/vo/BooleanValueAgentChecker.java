package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("BooleanValueAgentChecker")
public class BooleanValueAgentChecker extends Checker {
    private BooleanValueAgentCheckerDetectedValue detectedValue;
    
    @Override
    public CheckerDetectedValue getDetectedValue() {
        return detectedValue;
    }
}