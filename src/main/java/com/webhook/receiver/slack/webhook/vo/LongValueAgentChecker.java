package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("LongValueAgentChecker")
public class LongValueAgentChecker extends Checker {
    private LongValueAgentCheckerDetectedValue detectedValue;
    
    @Override
    public CheckerDetectedValue getDetectedValue() {
        return detectedValue;
    }
}