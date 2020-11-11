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
    
    private String getContent(String checkerType) {
         return "{\"pinpointUrl\":\"http://pinpoint.com\",\"batchEnv\":\"release\",\"applicationId\":\"TESTAPP\",\"serviceType\":\"TOMCAT\",\"checkerName\":\"HEAP USAGE RATE\",\"checkerType\":\"LongValueAgentChecker\",\"userGroup\":{\"userGroupId\":\"Group-1\",\"userGroupMembers\":[{\"id\":null,\"name\":\"minsookim\",\"email\":\"pinpoint@naver.com\",\"department\":\"Platform\",\"phoneNumber\":\"01012345678\",\"phoneCountryCode\":82}]},\"checkerDetectedValue\":{\"type\":\"\",\"value\":[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]},\"unit\":\"%\",\"threshold\":5,\"notes\":\"Note Example\",\"sequenceCount\":4}\n";
    }
    
    @Test
    public void BooleanValueAgentCheckerTest() throws IOException {
        String content = "{\"pinpointUrl\":\"http://pinpoint.com\",\"batchEnv\":\"release\",\"applicationId\":\"TESTAPP\",\"serviceType\":\"TOMCAT\",\"checkerName\":\"HEAP USAGE RATE\",\"checkerType\":\"LongValueAgentChecker\",\"userGroup\":{\"userGroupId\":\"Group-1\",\"userGroupMembers\":[{\"id\":null,\"name\":\"minsookim\",\"email\":\"pinpoint@naver.com\",\"department\":\"Platform\",\"phoneNumber\":\"01012345678\",\"phoneCountryCode\":82}]},\"checkerDetectedValue\":{\"type\":\"BooleanValueAgentChecker\",\"value\":[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]},\"unit\":\"%\",\"threshold\":5,\"notes\":\"Note Example\",\"sequenceCount\":4}\n";
        
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof BooleanValueAgentCheckerDetectedValue);
    }
    
    @Test(expected = Exception.class)
    public void NotExistCheckerNameTest() throws IOException {
        String content = "{\"pinpointUrl\":\"http://pinpoint.com\",\"batchEnv\":\"release\",\"applicationId\":\"TESTAPP\",\"serviceType\":\"TOMCAT\",\"checkerName\":\"HEAP USAGE RATE\",\"checkerType\":\"LongValueAgentChecker\",\"userGroup\":{\"userGroupId\":\"Group-1\",\"userGroupMembers\":[{\"id\":null,\"name\":\"minsookim\",\"email\":\"pinpoint@naver.com\",\"department\":\"Platform\",\"phoneNumber\":\"01012345678\",\"phoneCountryCode\":82}]},\"checkerDetectedValue\":{\"type\":\"NotExist\",\"value\":[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]},\"unit\":\"%\",\"threshold\":5,\"notes\":\"Note Example\",\"sequenceCount\":4}\n";
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
    }
    
    @Test
    public void LongValueAlarmCheckerTest() throws IOException {
    }
    
    @Test
    public void LongValueAgentCheckerTest() throws IOException {
    }
    
    @Test
    public void DataSourceAlarmListValueCheckerTest() throws IOException {
    }
    
}
