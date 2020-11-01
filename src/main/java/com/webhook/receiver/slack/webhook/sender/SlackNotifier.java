package com.webhook.receiver.slack.webhook.sender;

import com.webhook.receiver.slack.webhook.sender.vo.SlackPayload;
import com.webhook.receiver.slack.webhook.vo.WebhookPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SlackNotifier {
    
    private final Logger logger = LoggerFactory.getLogger(SlackNotifier.class.getName());
    private final RestTemplate restTemplate;
    
    @Value("${slack.webhook.url}")
    private String incomingWebhookUrl;
    
    private static final String SLACK_MESSAGE_TEMPLATE = "[PINPOINT-%s] %s Alarm for %s Service. %s, (Threshold: %s%s) #%s ";
    
    public SlackNotifier(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public boolean send(WebhookPayload webhookPayload) {
        if(incomingWebhookUrl.isEmpty()) {
            logger.error("slack incoming webhook url is empty in application.properties");
            return false;
        }
        
        String sendMessage = generateMessage(webhookPayload);
        SlackPayload slackPayload = new SlackPayload(sendMessage);
        
        try {
            restTemplate.postForObject(new URI(incomingWebhookUrl), slackPayload, String.class);
            logger.info("Send Slack : {}", sendMessage);
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
    
    private String generateMessage(WebhookPayload webhookPayload) {
        return String.format(SLACK_MESSAGE_TEMPLATE,
                webhookPayload.getBatchEnv(),
                webhookPayload.getCheckerName(),
                webhookPayload.getApplicationId(),
                webhookPayload.getCheckerDetectedValue().getMessage(),
                webhookPayload.getThreshold(),
                webhookPayload.getUnit(),
                webhookPayload.getSequenceCount()
        );
    }
}
