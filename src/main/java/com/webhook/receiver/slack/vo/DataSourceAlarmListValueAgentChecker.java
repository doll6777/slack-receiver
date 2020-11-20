package com.webhook.receiver.slack.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("DataSourceAlarmListValueAgentChecker")
public class DataSourceAlarmListValueAgentChecker extends AgentChecker<DataSourceAlarmList> {
    
    @JsonCreator
    public DataSourceAlarmListValueAgentChecker(List<DetectedAgent<DataSourceAlarmList>> detectedValue) {
        super(detectedValue);
    }
}
