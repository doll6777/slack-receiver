package com.webhook.receiver.slack.webhook.dto;

import java.util.Map;

public abstract class AgentCheckerDetectedValue<T> extends CheckerDetectedValue {
    
    protected Map<String, T> agentValues;
    
    public AgentCheckerDetectedValue(String unit, Map<String, T> agentValues) {
        super(unit);
        this.agentValues = agentValues;
    }
    
    public Map<String, T> getAgentValues() {
        return agentValues;
    }
 
    public abstract String getMessage();
}
