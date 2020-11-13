package com.webhook.receiver.slack.webhook.vo;

public class DetectedAgent<T> {
    
    private String agentId;
    private T agentValue;
    
    public String getAgentId() {
        return agentId;
    }
    
    public T getAgentValue() {
        return agentValue;
    }
    
    @Override
    public String toString() {
        return "{" +
                "agentId='" + agentId + '\'' +
                ", agentValue=" + agentValue +
                '}';
    }
}
