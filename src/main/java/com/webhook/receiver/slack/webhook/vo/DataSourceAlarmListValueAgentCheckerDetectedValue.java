package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public class DataSourceAlarmListValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<List<DataSourceAlarm>> {
    
    public DataSourceAlarmListValueAgentCheckerDetectedValue(List<DetectedAgent<List<DataSourceAlarm>>> detectedAgents) {
        super(detectedAgents);
    }
    
    @Override
    public String getMessage() {
        return "Message";
    }
}
