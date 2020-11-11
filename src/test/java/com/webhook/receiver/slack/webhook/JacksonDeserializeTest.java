package com.webhook.receiver.slack.webhook;

import com.webhook.receiver.slack.webhook.vo.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@JsonTest
public class JacksonDeserializeTest {
    
    @Autowired
    private JacksonTester<WebhookPayload> json;
    
    private String getContent(String checkerType, String value) {
        return "{\"pinpointUrl\":\"http://pinpoint.com\"," +
                "\"batchEnv\":\"release\"," +
                "\"applicationId\":\"TESTAPP\"," +
                "\"serviceType\":\"TOMCAT\"," +
                "\"checkerName\":\"HEAP USAGE RATE\"," +
                "\"checkerType\":\"LongValueAgentChecker\"," +
                "\"userGroup\":{\"userGroupId\":\"Group-1\"," +
                "\"userGroupMembers\":[{\"id\":null,\"name\":\"minsookim\"," +
                "\"email\":\"pinpoint@naver.com\",\"department\":\"Platform\"," +
                "\"phoneNumber\":\"01012345678\",\"phoneCountryCode\":82}]}," +
                "\"checkerDetectedValue\":{\"type\":\"" + checkerType + "\",\"value\":" + value + "},\"unit\":\"%\",\"threshold\":5,\"notes\":\"Note Example\"," +
                "\"sequenceCount\":4}\n";
    }
    
    @Test
    public void BooleanValueAgentCheckerTest() throws IOException {
        String content = getContent("BooleanValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]");
        
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof BooleanValueAgentCheckerDetectedValue);
    }
    
    @Test(expected = Exception.class)
    public void NotExistCheckerNameTest() throws IOException {
        String content = getContent("NotExistChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]");
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
    }
    
    @Test
    public void LongValueAlarmCheckerTest() throws IOException {
        String content = getContent("LongValueAlarmChecker", "1");
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof LongValueAlarmCheckerDetectedValue);
    }
    
    @Test
    public void LongValueAgentCheckerTest() throws IOException {
        String content = getContent("LongValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":1}]");
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof LongValueAgentCheckerDetectedValue);
    }
    
    @Test
    public void DataSourceAlarmListValueCheckerTest() throws IOException {
        String content = getContent("DataSourceAlarmListValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":[{\"databaseName\":\"databaseName\",\"connectionValue\":1}]}]");
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof DataSourceAlarmListValueAgentCheckerDetectedValue);
    }
    
}
