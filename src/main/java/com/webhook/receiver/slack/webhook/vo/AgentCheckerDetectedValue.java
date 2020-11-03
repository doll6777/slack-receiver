package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public abstract class AgentCheckerDetectedValue<T> implements CheckerDetectedValue {
    protected List<DetectedAgent<T>> value;
    
    protected AgentCheckerDetectedValue(List<DetectedAgent<T>> detectedAgents) {
        this.value = detectedAgents;
    }
    
    public List<DetectedAgent<T>> getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        StringBuilder agentValues = new StringBuilder();
        for (DetectedAgent<T> detectedAgent : value) {
            agentValues.append(detectedAgent.toString());
        }
        return agentValues.toString();
    }
}
