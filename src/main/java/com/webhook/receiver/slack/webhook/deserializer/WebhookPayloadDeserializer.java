package com.webhook.receiver.slack.webhook.deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.receiver.slack.webhook.vo.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WebhookPayloadDeserializer extends JsonDeserializer<WebhookPayload> {
    
    private static final String LONG_VALUE_AGENT_CHECKER = "LongValueAgentChecker";
    private static final String LONG_VALUE_ALARM_CHECKER = "LongValueAlarmChecker";
    private static final String BOOLEAN_VALUE_AGENT_CHECKER = "BooleanValueAgentChecker";
    private static final String DATA_SOURCE_ALARM_LIST_VALUE_AGENT_CHECKER = "DataSourceAlarmListValueAgentChecker";
    
    private final ObjectMapper objectMapper;
    
    public WebhookPayloadDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    @Override
    public WebhookPayload deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode jsonNode = jp.readValueAsTree();
        if (!jsonNode.isObject()) {
            throw new JsonParseException(jp, "Content is not Json Object");
        }
        
        String pinpointUrl = jsonNode.get("pinpointUrl").asText();
        String batchEnv = jsonNode.get("batchEnv").asText();
        String applicationId = jsonNode.get("applicationId").asText();
        String serviceType = jsonNode.get("serviceType").asText();
        String checkerName = jsonNode.get("checkerName").asText();
        String checkerType = jsonNode.get("checkerType").asText();
        String unit = jsonNode.get("unit").asText();
        Integer threshold = jsonNode.get("threshold").asInt();
        String notes = jsonNode.get("notes").asText();
        Integer sequenceCount = jsonNode.get("sequenceCount").asInt();
        UserGroup userGroup = objectMapper.treeToValue(jsonNode.get("userGroup"), UserGroup.class);
//        CheckerDetectedValue checkerDetectedValue = objectMapper.treeToValue(jsonNode.get("checkerDetectedValue"), CheckerDetectedValue.class);
    
        JsonNode checkerDetectedValueNode = jsonNode.get("checkerDetectedValue");
        CheckerDetectedValue checkerDetectedValue = getDetectedAgents(checkerDetectedValueNode, checkerType);
        
        return new WebhookPayload(pinpointUrl, batchEnv, applicationId, serviceType, checkerName, checkerType,
                userGroup, checkerDetectedValue, unit, threshold, notes, sequenceCount);
    }
    
    private CheckerDetectedValue getDetectedAgents(JsonNode checkerDetectedValueNode, String checkerType) throws JsonProcessingException {
        List detectedAgents;
        CheckerDetectedValue checkerDetectedValue = null;
    
        switch(checkerType) {
            case LONG_VALUE_ALARM_CHECKER:
                checkerDetectedValue = new LongValueAlarmCheckerDetectedValue(checkerDetectedValueNode.asLong());
                break;
            case LONG_VALUE_AGENT_CHECKER:
                detectedAgents = Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
                checkerDetectedValue = new LongValueAgentCheckerDetectedValue(detectedAgents);
                break;
            case BOOLEAN_VALUE_AGENT_CHECKER:
                detectedAgents = Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
                checkerDetectedValue = new BooleanValueAgentCheckerDetectedValue(detectedAgents);
                break;
            case DATA_SOURCE_ALARM_LIST_VALUE_AGENT_CHECKER:
                detectedAgents = Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
                checkerDetectedValue = new DataSourceAlarmListValueAgentCheckerDetectedValue(detectedAgents);
                break;
        }
        return checkerDetectedValue;
    }
}
