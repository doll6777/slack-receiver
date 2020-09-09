package com.webhook.receiver.slack.webhook;

import com.google.gson.Gson;
import com.webhook.receiver.slack.webhook.dto.PinpointWebhookPayload;
import com.webhook.receiver.slack.webhook.dto.SlackPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SlackNotifier {
    
    private final Logger logger = LoggerFactory.getLogger(SlackNotifier.class.getName());
    private final RestTemplate restTemplate;
    private final Gson gson = new Gson();
    
    @Value("${slack.webhook.url}")
    private String slackIncomingWebhookUrl;
    
    public SlackNotifier(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public void send(PinpointWebhookPayload webhookPayload) {
        String text = "[PINPOINT] applicationId:" + webhookPayload.getApplicationId() +
                ", checkerName: " + webhookPayload.getCheckerName() +
                " ( " + webhookPayload.getCheckerValue() + " > " +
                webhookPayload.getThreshold() +
                " ) , receiverId: " +
                webhookPayload.getUserGroupMemberPayload().getUserGroupId();
        
        SlackPayload slackPayload = new SlackPayload(text);
        String slackPayloadToSend = gson.toJson(slackPayload);
        HttpEntity<String> httpEntity = new HttpEntity<>(slackPayloadToSend);
        
        try {
            restTemplate.exchange(new URI(slackIncomingWebhookUrl), HttpMethod.POST, httpEntity, String.class);
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
        }
    }
    
}
