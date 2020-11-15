package com.webhook.receiver.slack.webhook.vo;

public class DataSourceAlarm {
    private String databaseName;
    private long connectionValue;
    
    public DataSourceAlarm(String databaseName, long connectionValue) {
        this.databaseName = databaseName;
        this.connectionValue = connectionValue;
    }
    
    public String getDatabaseName() {
        return databaseName;
    }
    
    public long getConnectionValue() {
        return connectionValue;
    }
    
    @Override
    public String toString() {
        return "{" +
                "databaseName='" + databaseName + '\'' +
                ", connectionValue=" + connectionValue +
                '}';
    }
}
