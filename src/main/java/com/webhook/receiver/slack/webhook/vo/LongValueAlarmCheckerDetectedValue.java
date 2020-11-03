package com.webhook.receiver.slack.webhook.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("LongValueAlarmChecker")
public class LongValueAlarmCheckerDetectedValue extends AlarmCheckerDetectedValue<Long> {
    
    @JsonCreator
    public LongValueAlarmCheckerDetectedValue(Long value) {
        super(value);
    }
}
