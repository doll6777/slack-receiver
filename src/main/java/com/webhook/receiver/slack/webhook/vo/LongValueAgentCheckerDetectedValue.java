package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("LongValueAgentChecker")
public class LongValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Long> {
    
    @JsonCreator
    public LongValueAgentCheckerDetectedValue(List<DetectedAgent<Long>> value) {
        super(value);
    }
}
