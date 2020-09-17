package com.webhook.receiver.slack.webhook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.receiver.slack.webhook.dto.SlackPayload;
import com.webhook.receiver.slack.webhook.dto.WebhookPayload;
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
    private final ObjectMapper objectMapper;
    
    @Value("${slack.webhook.url}")
    private String slackIncomingWebhookUrl;
    
    public SlackNotifier(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    
    public void send(WebhookPayload webhookPayload) {
        StringBuilder message = new StringBuilder();
        message.append(String.format("[PINPOINT-%s] %s Alarm for %s Service. ",
                webhookPayload.getBatchEnv(), webhookPayload.getCheckerName(), webhookPayload.getApplicationId()));
        message.append(webhookPayload.getCheckerDetectedValue().getMessage());
        message.append(String.format(" (Threshold: %s%s) #%s ",
                webhookPayload.getThreshold(), webhookPayload.getCheckerDetectedValue().getUnit(), webhookPayload.getSequenceCount()));
        
        SlackPayload slackPayload = new SlackPayload(message.toString());
        String slackPayloadToSend = null;
        try {
            slackPayloadToSend = objectMapper.writeValueAsString(slackPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(slackPayloadToSend);
        try {
            restTemplate.exchange(new URI(slackIncomingWebhookUrl), HttpMethod.POST, httpEntity, String.class);
            logger.info("Send Slack : {}", message.toString());
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
        }
    }
}
