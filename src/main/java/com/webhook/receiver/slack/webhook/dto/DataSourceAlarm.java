package com.webhook.receiver.slack.webhook.dto;

public class DataSourceAlarm {
    
    private int id;
    private String databaseName;
    private long connectionUsedRate;
    
    public DataSourceAlarm(int id, String databaseName, long connectionUsedRate) {
        this.id = id;
        this.databaseName = databaseName;
        this.connectionUsedRate = connectionUsedRate;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDatabaseName() {
        return databaseName;
    }
    
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    public long getConnectionUsedRate() {
        return connectionUsedRate;
    }
    
    public void setConnectionUsedRate(long connectionUsedRate) {
        this.connectionUsedRate = connectionUsedRate;
    }
}
