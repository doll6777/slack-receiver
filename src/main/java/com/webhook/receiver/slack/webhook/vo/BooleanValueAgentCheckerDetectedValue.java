package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public class BooleanValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Boolean> {
    
    public BooleanValueAgentCheckerDetectedValue(List<DetectedAgent<Boolean>> detectedAgents) {
        super(detectedAgents);
    }
    
    @Override
    public String getMessage() {
        return "Message";
    }
}
