package com.webhook.receiver.slack.webhook.vo;

import java.util.ArrayList;

public abstract class DetectedAgents<T> extends ArrayList<DetectedAgent<T>> {
    @Override
    public String toString() {
        StringBuilder agentValues = new StringBuilder();
        for (DetectedAgent<T> detectedAgent : this) {
            agentValues.append(detectedAgent.toString()).append("\n");
        }
        return agentValues.toString();
    }
}
