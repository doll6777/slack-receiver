package com.webhook.receiver.slack.webhook;

import com.google.gson.Gson;
import com.webhook.receiver.slack.webhook.dto.PinpointWebhookPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class WebhookSendController {

    private final SlackNotifier slackNotifier;
    private final Gson gson = new Gson();
    
    public WebhookSendController(SlackNotifier slackNotifier) {
        this.slackNotifier = slackNotifier;
    }
    
    @RequestMapping(value = "/slack", method = RequestMethod.POST)
    public ResponseEntity<Void> sendWebhook(@RequestBody String payload) {
        // TODO: CheckerValue 추상클래스 역직렬화
        PinpointWebhookPayload pinpointWebhookPayload = gson.fromJson(payload, PinpointWebhookPayload.class);
        slackNotifier.send(pinpointWebhookPayload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}