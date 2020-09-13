package com.webhook.receiver.slack.webhook.dto;

import java.util.Map;

public class LongValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<Long> {
    
    public LongValueAgentCheckerDetectedValue(String unit, Map<String, Long> agentValues) {
        super(unit, agentValues);
    }
    
    @Override
    public Map<String, Long> getAgentValues() {
        return agentValues;
    }
    
    @Override
    public String getUnit() {
        return unit;
    }
    
    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        for (Map.Entry<String, Long> detected : getAgentValues().entrySet()) {
            message.append(String.format(" Value of agent(%s) is %s%s during the past 5 mins.",detected.getKey(), detected.getValue(), unit));
        }
        return message.toString();
    }
}
