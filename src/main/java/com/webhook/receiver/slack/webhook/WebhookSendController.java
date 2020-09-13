package com.webhook.receiver.slack.webhook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.receiver.slack.webhook.dto.*;
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
    public ResponseEntity<Void> sendWebhook(@RequestBody String payload) {
        // TODO: CheckerValue 추상클래스 역직렬화
        WebhookPayload webhookPayload = null;
        try {
            webhookPayload = deserialize(payload);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        slackNotifier.send(webhookPayload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private WebhookPayload deserialize(String payload) throws Exception {
        WebhookPayload webhookPayload = new WebhookPayload();
        JsonNode jsonNode = objectMapper.readTree(payload);
        
        CheckerDetectedValue checkerDetectedValue = bindCheckerDetectedValue(jsonNode);
        
        webhookPayload.setPinpointUrl(jsonNode.get("pinpointUrl").asText());
        webhookPayload.setBatchEnv(jsonNode.get("batchEnv").asText());
        webhookPayload.setSequenceCount(jsonNode.get("sequenceCount").asInt());
        webhookPayload.setApplicationId(jsonNode.get("applicationId").asText());
        webhookPayload.setCheckerName(jsonNode.get("checkerName").asText());
        webhookPayload.setThreshold(jsonNode.get("threshold").asInt());
        webhookPayload.setNotes(jsonNode.get("notes").asText());
        webhookPayload.setCheckerType(jsonNode.get("checkerType").asText());
        webhookPayload.setUserGroupMemberPayload(objectMapper
                .readValue(jsonNode.get("userGroupMemberPayload").toString(), UserGroupMemberPayload.class));
        webhookPayload.setCheckerDetectedValue(checkerDetectedValue);
        return webhookPayload;
    }
    
    private CheckerDetectedValue bindCheckerDetectedValue(JsonNode jsonNode) throws Exception {
        String checkerType = jsonNode.get("checkerType").asText();
        if (checkerType.equals("LongValueAlarmChecker")) {
            return objectMapper.readValue(jsonNode.get("checkerDetectedValue").toString(), LongValueAlarmCheckerDetectedValue.class);
        } else if (checkerType.equals("LongValueAgentChecker")) {
            return objectMapper.readValue(jsonNode.get("checkerDetectedValue").toString(), LongValueAgentCheckerDetectedValue.class);
        } else if (checkerType.equals("BooleanValueAgentChecker")) {
            return objectMapper.readValue(jsonNode.get("checkerDetectedValue").toString(), BooleanValueAgentCheckerDetectedValue.class);
        } else if (checkerType.equals("DataSourceAlarmListValueAgentChecker")) {
            return objectMapper.readValue(jsonNode.get("checkerDetectedValue").toString(), DataSourceAlarmListValueAgentCheckerDetectedValue.class);
        } else {
            throw new Exception();
        }
    }
}