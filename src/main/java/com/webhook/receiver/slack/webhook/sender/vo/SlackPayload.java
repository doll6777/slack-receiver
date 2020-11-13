package com.webhook.receiver.slack.webhook.sender.vo;

import java.util.List;

public class SlackPayload {
    private String text;
    private List<SlackAttachment> attachments;
    
    public SlackPayload(String text, List<SlackAttachment> attachments) {
        this.text = text;
        this.attachments = attachments;
    }
    
    public SlackPayload(List<SlackAttachment> attachments) {
        this.attachments = attachments;
    }
    
    public String getText() {
        return text;
    }
    
    public List<SlackAttachment> getAttachments() {
        return attachments;
    }
}
