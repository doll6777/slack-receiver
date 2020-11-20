package com.webhook.receiver.slack.controller;

import com.webhook.receiver.slack.sender.Notifier;
import com.webhook.receiver.slack.vo.WebhookPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
public class WebhookSendController {
    
    private final Notifier slackNotifier;
    
    public WebhookSendController(Notifier slackNotifier) {
        this.slackNotifier = slackNotifier;
    }
    
    @RequestMapping(value = "/slack", method = RequestMethod.POST)
    public ResponseEntity<Void> sendWebhook(@RequestBody WebhookPayload webhookPayload) {
        if(slackNotifier.send(webhookPayload)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}