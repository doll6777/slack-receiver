package com.webhook.receiver.slack.webhook.vo;

import java.util.List;


public class LongValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Long> {
    
    public LongValueAgentCheckerDetectedValue(List<DetectedAgent<Long>> detectedAgents) {
        super(detectedAgents);
    }
    
    @Override
    public String getMessage() {
        return "LongValueAgentChecker Message";
    }
}
