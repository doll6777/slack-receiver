package com.webhook.receiver.slack.webhook.sender;

import com.webhook.receiver.slack.webhook.sender.vo.Field;
import com.webhook.receiver.slack.webhook.sender.vo.SlackAttachment;
import com.webhook.receiver.slack.webhook.sender.vo.SlackPayload;
import com.webhook.receiver.slack.webhook.vo.WebhookPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
public class SlackNotifier implements Notifier {
    
    private final Logger logger = LoggerFactory.getLogger(SlackNotifier.class.getName());
    private final RestTemplate restTemplate;
    private final String incomingWebhookUrl;
    
    @Autowired
    public SlackNotifier(RestTemplate restTemplate, @Value("${slack.webhook.url}") final String incomingWebhookUrl) {
        this.restTemplate = restTemplate;
        this.incomingWebhookUrl = incomingWebhookUrl;
    }
    
    public boolean send(WebhookPayload webhookPayload) {
        if(incomingWebhookUrl.isEmpty()) {
            logger.error("slack incoming webhook url is empty in application.properties");
            return false;
        }
        
        List<SlackAttachment> attachments = buildAttachments(webhookPayload);
        SlackPayload slackPayload = new SlackPayload(attachments);
        
        try {
            restTemplate.postForObject(new URI(incomingWebhookUrl), slackPayload, String.class);
            logger.info("Sent slack message to {}", incomingWebhookUrl);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
    
    List<SlackAttachment> buildAttachments(WebhookPayload webhookPayload) {
        SlackAttachment slackAttachment = new SlackAttachment();
    
        Field applicationIdField = new Field("applicationId", webhookPayload.getApplicationId());
        Field sequenceCountField = new Field("sequenceCount", webhookPayload.getSequenceCount().toString());
        Field unitField = new Field("unit", webhookPayload.getUnit());
        Field thresholdField = new Field("threshold", webhookPayload.getThreshold().toString());
        Field detectedValue = new Field("detectedValue", webhookPayload.getCheckerDetectedValue().toString());
        Field envField = new Field("env", webhookPayload.getBatchEnv());
    
        slackAttachment.addField(envField);
        slackAttachment.addField(applicationIdField);
        slackAttachment.addField(sequenceCountField);
        slackAttachment.addField(unitField);
        slackAttachment.addField(thresholdField);
        slackAttachment.addField(detectedValue);
    
        List<SlackAttachment> attachmentList = new ArrayList<>();
        attachmentList.add(slackAttachment);
        return attachmentList;
    }
}
