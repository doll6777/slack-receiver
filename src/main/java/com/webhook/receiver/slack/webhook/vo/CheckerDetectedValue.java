package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LongValueAgentCheckerDetectedValue.class, name = "LongValueAgentChecker"),
        @JsonSubTypes.Type(value = LongValueAlarmCheckerDetectedValue.class, name = "LongValueAlarmChecker"),
        @JsonSubTypes.Type(value = BooleanValueAgentCheckerDetectedValue.class, name = "BooleanValueAgentChecker"),
        @JsonSubTypes.Type(value = DataSourceAlarmListValueAgentCheckerDetectedValue.class, name = "DataSourceAlarmListValueAgentChecker"),
})
public interface CheckerDetectedValue {
}