package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("DataSourceAlarmListValueAgentChecker")
public class DataSourceAlarmListValueAgentChecker extends Checker {
    private DataSourceAlarmListValueAgentCheckerDetectedValue detectedValue;
    
    @Override
    public CheckerDetectedValue getDetectedValue() {
        return detectedValue;
    }
}