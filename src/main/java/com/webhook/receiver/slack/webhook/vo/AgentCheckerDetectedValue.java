package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public abstract class AgentCheckerDetectedValue<T> implements CheckerDetectedValue {
    public AgentCheckerDetectedValue() {
    }
    
    protected List<DetectedAgent<T>> detectedAgents;
    
    protected AgentCheckerDetectedValue(List<DetectedAgent<T>> detectedAgents) {
        this.detectedAgents = detectedAgents;
    }
    
    public List<DetectedAgent<T>> getDetectedAgents() {
        return detectedAgents;
    }
}
