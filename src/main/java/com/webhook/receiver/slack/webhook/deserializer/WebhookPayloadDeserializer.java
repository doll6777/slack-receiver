package com.webhook.receiver.slack.webhook.deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.webhook.receiver.slack.webhook.vo.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class WebhookPayloadDeserializer extends JsonDeserializer<WebhookPayload> {
    
    private ObjectMapper objectMapper;
    
    public WebhookPayloadDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    @Override
    public WebhookPayload deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
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
        
        CheckerDetectedValue checkerDetectedValue = null;
        JsonNode checkerDetectedValueNode = jsonNode.get("checkerDetectedValue");
        if (checkerType.equals("LongValueAlarmChecker")) {
            checkerDetectedValue = new LongValueAlarmCheckerDetectedValue(checkerDetectedValueNode.asLong());
        }

        if (checkerType.equals("LongValueAgentChecker")) {
            List<DetectedAgent<Long>> detectedAgents =
                    Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
            checkerDetectedValue = new LongValueAgentCheckerDetectedValue(detectedAgents);
        }

        if (checkerType.equals("BooleanValueAgentChecker")) {
            List<DetectedAgent<Boolean>> detectedAgents =
                    Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
            checkerDetectedValue = new BooleanValueAgentCheckerDetectedValue(detectedAgents);
        }

        if (checkerType.equals("DataSourceAlarmListValueAgentChecker")) {
            List<DetectedAgent<List<DataSourceAlarm>>> detectedAgents =
                    Arrays.asList(objectMapper.treeToValue(checkerDetectedValueNode, DetectedAgent[].class));
            checkerDetectedValue = new DataSourceAlarmListValueAgentCheckerDetectedValue(detectedAgents);
        }
        
        return new WebhookPayload(pinpointUrl, batchEnv, applicationId, serviceType, checkerName, checkerType,
                userGroup, checkerDetectedValue, unit, threshold, notes, sequenceCount);
    }
}
