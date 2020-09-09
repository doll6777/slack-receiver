package com.webhook.receiver.slack.webhook.dto;

import java.util.Map;

public class AgentCheckerValue<T> extends CheckerValue {
    
    private Map<String, T> AgentValues;
    
    public AgentCheckerValue(String unit, Map<String, T> agentValues) {
        super(unit);
        AgentValues = agentValues;
    }
    
    public Map<String, T> getAgentValues() {
        return AgentValues;
    }
}
