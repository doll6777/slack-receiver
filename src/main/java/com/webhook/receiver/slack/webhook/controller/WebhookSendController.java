package com.webhook.receiver.slack.webhook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.receiver.slack.webhook.vo.WebhookPayload;
import com.webhook.receiver.slack.webhook.sender.SlackNotifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
public class WebhookSendController {
    
    private final SlackNotifier slackNotifier;
    private final ObjectMapper objectMapper;
    
    public WebhookSendController(SlackNotifier slackNotifier, ObjectMapper objectMapper) {
        this.slackNotifier = slackNotifier;
        this.objectMapper = objectMapper;
    }
    
    @RequestMapping(value = "/slack", method = RequestMethod.POST)
    public ResponseEntity sendWebhook(@RequestBody String payload) throws JsonProcessingException {
        WebhookPayload webhookPayload = objectMapper.readValue(payload, WebhookPayload.class);
        System.out.println(webhookPayload);
        
        // TODO: Slack Send
//        slackNotifier.send(webhookPayload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}