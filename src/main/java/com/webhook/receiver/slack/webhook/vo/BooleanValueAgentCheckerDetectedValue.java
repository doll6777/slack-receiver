package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("BooleanValueAgentChecker")
public class BooleanValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Boolean> {
    
    @JsonCreator
    public BooleanValueAgentCheckerDetectedValue(List<DetectedAgent<Boolean>> value) {
        super(value);
    }
}
