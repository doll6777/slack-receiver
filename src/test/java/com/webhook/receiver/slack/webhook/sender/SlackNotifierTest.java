package com.webhook.receiver.slack.webhook.sender;

import com.webhook.receiver.slack.webhook.sender.vo.SlackPayload;
import com.webhook.receiver.slack.webhook.vo.LongValueAlarmChecker;
import com.webhook.receiver.slack.webhook.vo.UserGroup;
import com.webhook.receiver.slack.webhook.vo.WebhookPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SlackNotifierTest {
    
    @InjectMocks
    SlackNotifier slackNotifier;
    
    @Mock
    RestTemplate restTemplate;
    
    @BeforeAll
    static void beforeAll() {
    }
    
    @Test
    void sendFailWhenIncomingUrlEmpty() {
        slackNotifier = new SlackNotifier(restTemplate, "");
    
        WebhookPayload payload = new WebhookPayload("pinpointUrl", "release", "applicationId", "serviceType", new UserGroup("userGroupId", new ArrayList<>()), new LongValueAlarmChecker(1L), "%", 1, "", 1);
    
        boolean result = slackNotifier.send(payload);
        Assertions.assertFalse(result);
    }
    
    @Test
    void sendFailWhenRestClientException() {
        lenient().when(restTemplate.postForObject(any(URI.class), any(SlackPayload.class), eq(String.class))).thenThrow(RestClientException.class);
        
        slackNotifier = new SlackNotifier(restTemplate, "http://webhook.url.com");
    
        WebhookPayload payload = new WebhookPayload("pinpointUrl", "release", "applicationId", "serviceType", new UserGroup("userGroupId", new ArrayList<>()), new LongValueAlarmChecker(1L), "%", 1, "", 1);
        
        boolean result = slackNotifier.send(payload);
        Assertions.assertFalse(result);
    }
    
    @Test
    void sendSuccess() {
        when(restTemplate.postForObject(any(URI.class), any(SlackPayload.class), eq(String.class))).thenReturn("");
        slackNotifier = new SlackNotifier(restTemplate, "http://webhook.send.com");
    
        WebhookPayload payload = new WebhookPayload("pinpointUrl", "release", "applicationId", "serviceType", new UserGroup("userGroupId", new ArrayList<>()), new LongValueAlarmChecker(1L), "%", 1, "", 1);

        boolean result = slackNotifier.send(payload);
        Assertions.assertTrue(result);
    }
    
}