package com.webhook.receiver.slack.webhook;

import com.webhook.receiver.slack.webhook.vo.*;
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
        
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof BooleanValueAgentCheckerDetectedValue);
    }
    
    @Test
    public void NotExistCheckerNameTest() {
        String content = TestJsonFactory.getNotExistCheckerContent();
    
        Assertions.assertThrows(Exception.class, ()-> {
            CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        });
    }
    
    @Test
    public void LongValueAlarmCheckerTest() throws IOException {
        String content = TestJsonFactory.getLongValueAlarmCheckerContent();
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof LongValueAlarmCheckerDetectedValue);
    }
    
    @Test
    public void LongValueAgentCheckerTest() throws IOException {
        String content = TestJsonFactory.getLongValueAgentCheckerContent();
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof LongValueAgentCheckerDetectedValue);
    }
    
    @Test
    public void DataSourceAlarmListValueCheckerTest() throws IOException {
        String content = TestJsonFactory.getDataSourceAlarmListValueAgentCheckerContent();
    
        CheckerDetectedValue detectedValue = json.parseObject(content).getCheckerDetectedValue();
        Assertions.assertTrue(detectedValue instanceof DataSourceAlarmListValueAgentCheckerDetectedValue);
    }
}
