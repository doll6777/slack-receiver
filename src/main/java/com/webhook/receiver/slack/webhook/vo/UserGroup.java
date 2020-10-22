package com.webhook.receiver.slack.webhook.vo;

import java.util.List;

public class UserGroup {
    
    private String userGroupId;
    private List<UserMember> userGroupMembers;
    
    public String getUserGroupId() {
        return userGroupId;
    }
    
    public List<UserMember> getUserGroupMembers() {
        return userGroupMembers;
    }
}
