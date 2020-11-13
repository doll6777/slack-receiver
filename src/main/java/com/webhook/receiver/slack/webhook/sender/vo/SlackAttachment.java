package com.webhook.receiver.slack.webhook.sender.vo;

import java.util.ArrayList;
import java.util.List;

public class SlackAttachment {
    
    private String color= "#f54242";
    private String fallback;
    private String title;
    private String text;
    private List<Field> fields = new ArrayList<>();
    
    public SlackAttachment() {
    }
    
    public SlackAttachment(String fallback, String title, String text) {
        this.fallback = fallback;
        this.title = title;
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public String getFallback() {
        return fallback;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getTitle() {
        return title;
    }
    
    public List<Field> getFields() {
        return fields;
    }
    
    public void setFields(List<Field> fieldList) {
        this.fields = fieldList;
    }
    
    public void addField(Field field) {
        this.fields.add(field);
    }
}
