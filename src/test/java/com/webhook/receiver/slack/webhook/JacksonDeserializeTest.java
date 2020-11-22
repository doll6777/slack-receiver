package com.webhook.receiver.slack.webhook;

import com.webhook.receiver.slack.vo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

@JsonTest
public class JacksonDeserializeTest {
    
    @Autowired
    private JacksonTester<WebhookPayload> json;
    
    @Test
    public void BooleanValueAgentCheckerTest() throws IOException {
        String content = TestJsonFactory.getBooleanValueCheckerContent();
        
        Checker detectedValue = json.parseObject(content).getChecker();
        Assertions.assertTrue(detectedValue instanceof BooleanValueAgentChecker);
    }
    
    @Test
    public void NotExistCheckerNameTest() {
        String content = TestJsonFactory.getNotExistCheckerContent();
    
        Assertions.assertThrows(Exception.class, ()-> {
            Checker detectedValue = json.parseObject(content).getChecker();
        });
    }
    
    @Test
    public void LongValueAlarmCheckerTest() throws IOException {
        String content = TestJsonFactory.getLongValueAlarmCheckerContent();
    
        Checker detectedValue = json.parseObject(content).getChecker();
        Assertions.assertTrue(detectedValue instanceof LongValueAlarmChecker);
    }
    
    @Test
    public void LongValueAgentCheckerTest() throws IOException {
        String content = TestJsonFactory.getLongValueAgentCheckerContent();
    
        Checker detectedValue = json.parseObject(content).getChecker();
        Assertions.assertTrue(detectedValue instanceof LongValueAgentChecker);
    }
    
    @Test
    public void DataSourceAlarmListValueCheckerTest() throws IOException {
        String content = TestJsonFactory.getDataSourceAlarmListValueAgentCheckerContent();
    
        Checker detectedValue = json.parseObject(content).getChecker();
        Assertions.assertTrue(detectedValue instanceof DataSourceAlarmListValueAgentChecker);
    }
}
