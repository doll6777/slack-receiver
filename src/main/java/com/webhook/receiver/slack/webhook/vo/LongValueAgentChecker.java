package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("LongValueAgentChecker")
public class LongValueAgentChecker extends AgentChecker<Long> {
    
    @JsonCreator
    public LongValueAgentChecker(List<DetectedAgent<Long>> detectedValue) {
        super(detectedValue);
    }
}
