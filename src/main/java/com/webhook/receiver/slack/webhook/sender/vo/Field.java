package com.webhook.receiver.slack.webhook.sender.vo;

public class Field {
    String title;
    String value;
    
    public Field(String title, String value) {
        this.title = title;
        this.value = value;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getValue() {
        return value;
    }
    
    public boolean getShort() {
        return true;
    }
}
