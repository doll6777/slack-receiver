package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LongValueAgentChecker.class, name = "LongValueAgentChecker"),
        @JsonSubTypes.Type(value = LongValueAlarmChecker.class, name = "LongValueAlarmChecker"),
        @JsonSubTypes.Type(value = BooleanValueAgentChecker.class, name = "BooleanValueAgentChecker"),
        @JsonSubTypes.Type(value = DataSourceAlarmListValueAgentChecker.class, name = "DataSourceAlarmListValueAgentChecker"),
})
public abstract class Checker {
    String name;
    public String getName() {
        return name;
    }
    public abstract String getDetectedValueString();
}