package com.webhook.receiver.slack.webhook.controller;

import com.webhook.receiver.slack.webhook.TestJsonFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = {WebhookSendController.class})
class WebhookSendControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    WebhookSendController loggedUserManager;
    
    @Test
    void sendWebhook_LongValueAlarmChecker_200() throws Exception {
        String webhookPayloadString = TestJsonFactory.getLongValueAlarmCheckerContent();
        
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayloadString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void sendWebhook_BooleanValueChecker_200() throws Exception {
        String webhookPayloadString = TestJsonFactory.getBooleanValueCheckerContent();
        
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayloadString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void sendWebhook_LongValueAgentChecker_200() throws Exception {
        String webhookPayloadString = TestJsonFactory.getLongValueAgentCheckerContent();
        
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayloadString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void sendWebhook_DataSourceAlarmListValueAgentChecker_200() throws Exception {
        String webhookPayloadString = TestJsonFactory.getDataSourceAlarmListValueAgentCheckerContent();
        
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayloadString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void sendWebhook_NotExistChecker_400() throws Exception {
        String webhookPayloadString = TestJsonFactory.getNotExistCheckerContent();
        
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayloadString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}