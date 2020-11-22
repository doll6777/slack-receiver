package com.webhook.receiver.slack.webhook;

public class TestJsonFactory {
    
    public static String getContent(String checkerType, String value) {
        return "{\"pinpointUrl\":\"http://pinpoint.com\"," +
                "\"batchEnv\":\"release\"," +
                "\"applicationId\":\"TESTAPP\"," +
                "\"serviceType\":\"TOMCAT\"," +
                "\"userGroup\":{\"userGroupId\":\"Group-1\"," +
                "\"userGroupMembers\":[{\"id\":null,\"name\":\"minsookim\"," +
                "\"email\":\"pinpoint@naver.com\",\"department\":\"Platform\"," +
                "\"phoneNumber\":\"01012345678\",\"phoneCountryCode\":82}]}," +
                "\"checker\": {\n" +
                "  \"name\": \"HEAP USAGE RATE\",\n" +
                "  \"type\": \"" + checkerType + "\",\n" +
                "  \"value\": " + value + " }," +
                "\"unit\":\"%\"," +
                "\"threshold\":5," +
                "\"notes\":\"Note Example\"," +
                "\"sequenceCount\":4}\n";
    }
    
    public static String getBooleanValueCheckerContent() {
        return getContent("BooleanValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]");
    }
    
    public static String getNotExistCheckerContent() {
        return getContent("NotExistChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":true}]");
    }
    
    public static String getLongValueAlarmCheckerContent() {
        return getContent("LongValueAlarmChecker", "1");
    }
    
    public static String getLongValueAgentCheckerContent() {
        return getContent("LongValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":1}]");
    }
    
    public static String getDataSourceAlarmListValueAgentCheckerContent() {
        return getContent("DataSourceAlarmListValueAgentChecker", "[{\"agentId\":\"agentIdtest\",\"agentValue\":[{\"databaseName\":\"databaseName\",\"connectionValue\":1}]}]");
    }
}
