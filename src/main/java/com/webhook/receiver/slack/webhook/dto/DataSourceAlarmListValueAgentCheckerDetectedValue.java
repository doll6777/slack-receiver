package com.webhook.receiver.slack.webhook.dto;

import java.util.List;
import java.util.Map;

public class DataSourceAlarmListValueAgentCheckerDetectedValue extends AgentCheckerDetectedValue<List<DataSourceAlarm>> {
    
    public DataSourceAlarmListValueAgentCheckerDetectedValue(String unit, Map<String, List<DataSourceAlarm>> agentValues) {
        super(unit, agentValues);
    }
    
    @Override
    public Map<String, List<DataSourceAlarm>> getAgentValues() {
        return agentValues;
    }
    
    @Override
    public String getUnit() {
        return unit;
    }
    
    @Override
    public String getMessage() {
        StringBuffer message = new StringBuffer();
        for (Map.Entry<String, List<DataSourceAlarm>> detected : getAgentValues().entrySet()) {
            for (DataSourceAlarm dataSourceAlarm : detected.getValue()) {
                message.append(String.format(" Value of agent(%s) has %s%s(DataSource %s connection pool usage) during the past 5 mins.", detected.getKey(), dataSourceAlarm.getConnectionUsedRate(), unit, dataSourceAlarm.getDatabaseName()));
            }
        }
        return message.toString();
    }
}
