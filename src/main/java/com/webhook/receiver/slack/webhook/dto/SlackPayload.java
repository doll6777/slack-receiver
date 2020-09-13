package com.webhook.receiver.slack.webhook.dto;

public class SlackPayload {
    private String text;
    
    public SlackPayload(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}
