package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public abstract class AgentChecker<T> extends Checker {
    protected List<DetectedAgent<T>> detectedValue;
    
    protected AgentChecker(List<DetectedAgent<T>> detectedAgents) {
        this.detectedValue = detectedAgents;
    }
    
    public List<DetectedAgent<T>> getDetectedValue() {
        return detectedValue;
    }
    
    @Override
    public String getDetectedValueString() {
        StringBuilder agentValues = new StringBuilder();
        for (DetectedAgent<T> detectedAgent : detectedValue) {
            agentValues.append(detectedAgent.toString()).append("\n");
        }
        return agentValues.toString();
    }
}
