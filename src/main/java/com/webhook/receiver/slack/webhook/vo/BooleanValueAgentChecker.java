package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("BooleanValueAgentChecker")
public class BooleanValueAgentChecker extends AgentChecker<Boolean> {
    
    @JsonCreator
    public BooleanValueAgentChecker(List<DetectedAgent<Boolean>> detectedValue) {
        super(detectedValue);
    }
}
