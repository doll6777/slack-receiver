package com.webhook.receiver.slack.webhook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.receiver.slack.webhook.vo.UserGroup;
import com.webhook.receiver.slack.webhook.vo.WebhookPayload;
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
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    WebhookSendController loggedUserManager;
    
    @Test
    void sendWebhook() throws Exception {
        String webhookPayload = objectMapper.writeValueAsString(new WebhookPayload( "", "", "", "", "", "LongVeAlarmChecker", new UserGroup(), null, "", 1, "", 1));
    
        mvc.perform(MockMvcRequestBuilders.post("/api/send/slack")
                .contentType(MediaType.APPLICATION_JSON)
                .content(webhookPayload)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}