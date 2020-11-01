package com.webhook.receiver.slack.webhook.sender;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

class SlackNotifierTest {
    
    @InjectMocks
    SlackNotifier slackNotifier;
    
    @Mock
    RestTemplate restTemplate;
    
    @BeforeAll
    static void beforeAll() {
//        Mockito.when(restTemplate.postForObject())
    }
    
    @Test
    void sendFailWhenIncomingUrlEmpty() {
    
    }
    
    @Test
    void sendFailWhenIncomingUrlInvalid() {
    
    }
    
    @Test
    void sendSuccess() {
    
    }
    
}