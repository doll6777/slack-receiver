package com.webhook.receiver.slack.webhook.dto;

import java.util.Map;

public class BooleanValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Boolean> {
    
    public BooleanValueAgentCheckerDetectedValue(String unit, Map<String, Boolean> agentValues) {
        super(unit, agentValues);
    }
    
    @Override
    public Map<String, Boolean> getAgentValues() {
        return getAgentValues();
    }
    
    @Override
    public String getUnit() {
        return unit;
    }
    
    @Override
    public String getMessage() {
        StringBuffer message = new StringBuffer();
        for (Map.Entry<String, Boolean> detected : agentValues.entrySet()) {
            message.append(String.format(" Value of agent(%s) has deadlocked thread during the past 5 mins.", detected.getKey()));
        }
        return message.toString();
    }
}
