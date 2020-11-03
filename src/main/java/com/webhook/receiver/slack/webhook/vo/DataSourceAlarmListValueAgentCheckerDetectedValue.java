package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("DataSourceAlarmListValueAgentChecker")
public class DataSourceAlarmListValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<List<DataSourceAlarm>> {
    
    @JsonCreator
    public DataSourceAlarmListValueAgentCheckerDetectedValue(List<DetectedAgent<List<DataSourceAlarm>>> value) {
        super(value);
    }
}
