package com.webhook.receiver.slack.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("LongValueAlarmChecker")
public class LongValueAlarmChecker extends AlarmChecker<Long> {
    
    @JsonCreator
    public LongValueAlarmChecker(Long detectedValue) {
        super(detectedValue);
    }
}
